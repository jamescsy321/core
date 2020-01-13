package com.fetnet.portal.aem.ebu.servlets;

import javax.jcr.NodeIterator;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.servlet.Servlet;

import org.apache.jackrabbit.api.jmx.QueryStatManagerMBean;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

import com.fetnet.portal.aem.ebu.utils.Network;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 * 
 *         This servlet uses the HTTP GET method to read a data from the RESTful
 *         webservice
 */
@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=JSON Servlet to read the data from the external webservice",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/readjsonSqlEbu" })
public class JSONServletSql extends SlingSafeMethodsServlet {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 4438376868274173005L;

	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(JSONServletSql.class);
	
    @Reference
    private QueryStatManagerMBean queryStatManagerMBean;
    
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		log.info("Reading the data from the webservice");
		try {
			final ResourceResolver resourceResolver = request.getResourceResolver();

			final Session session = resourceResolver.adaptTo(Session.class);
			final QueryManager qm = session.getWorkspace().getQueryManager();
			
			List<String> pathLists = new ArrayList<String>();  
			
			final Query query = qm.createQuery(
					"SELECT * FROM [nt:unstructured] AS s where ISDESCENDANTNODE ([/content/dam/fragmentexamples]) and name(s)=\"master\" ",
					Query.JCR_SQL2);
			QueryResult queryResult = query.execute();
			NodeIterator nodes = queryResult.getNodes();
		    while (nodes.hasNext()) {		   
		      pathLists.add(nodes.nextNode().getPath());
		    }
		    
			/**
			 * Getting the JSON string from the webservice
			 */
//			String responseString = queryResult.toString();
			
			
			/**
			 * Writing the entire JSON string on the browser
			 */
			
			response.setContentType("application/json");
			response.getWriter().print(getJsonDetail(pathLists));

            

		} catch (Exception e) {

			log.error(e.getMessage(), e);
		}
	}
	
	private JSONObject getJsonDetail(List<String> pathLists) {

		// ArrayList<String> detailLists = new ArrayList<String>();  
		JSONObject detailLists = new JSONObject();
		for (String list : pathLists) {
			String combineURL ="http://localhost:4502"+list+".json";
			String resultString = Network.readJsonByhttp(combineURL);	
			
			try {
				JSONObject jsonObject = new JSONObject (resultString);
				detailLists.put(combineURL, jsonObject);
			
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 } 

		return detailLists;
	}

}