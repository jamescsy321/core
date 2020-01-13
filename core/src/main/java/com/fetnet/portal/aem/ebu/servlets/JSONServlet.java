package com.fetnet.portal.aem.ebu.servlets;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import com.fetnet.portal.aem.ebu.utils.Network;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 * 
 * This servlet uses the HTTP GET method to read a data from the RESTful webservice
 */
@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=JSON Servlet to read the data from the external webservice",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/readjsonEbu" })
public class JSONServlet extends SlingSafeMethodsServlet {

	private static final String URL ="https://jsonplaceholder.typicode.com/todos/";
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 4438376868274173005L;
	
	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(JSONServlet.class);
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {

			log.info("Reading the data from the webservice");

			/**
			 * Getting the JSON string from the webservice
			 */
			String responseString = Network.readJson(URL);

			/**
			 * Writing the entire JSON string on the browser
			 */
			response.getWriter().println(responseString);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
		}
	}

}