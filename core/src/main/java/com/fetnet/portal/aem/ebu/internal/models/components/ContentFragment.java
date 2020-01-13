//package com.fetnet.portal.aem.ebu.internal.models.components;
//
//import javax.inject.Inject;
//
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Exporter;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.Optional;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//
//import com.adobe.cq.export.json.ComponentExporter;
//import com.adobe.cq.export.json.ExporterConstants;
//
//@Model(
//        adaptables = SlingHttpServletRequest.class, 
//        adapters = {ComponentExporter.class}, 
//        resourceType = ContentFragment.RESOURCE_TYPE
//)
//@Exporter(
//        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
//        extensions = ExporterConstants.SLING_MODEL_EXTENSION
//)
//public class ContentFragment implements ComponentExporter{
//	
//	static final String RESOURCE_TYPE = "ebu/components/contentfragment";
//	
//	@Optional
//	@ValueMapValue
//	private String[] elementNames;
//	
//	@Optional
//	@ValueMapValue
//	private String fragmentPath;
//	
//	@Inject
//	@Optional
//	@ValueMapValue
//	private Resource description;
//	
//	@Inject
//	@Optional
//	@ValueMapValue
//	private String model;
//	
//	
//
//	public Resource getDescription() {
//		return description;
//	}
//
//
//
//	public void setDescription(Resource description) {
//		this.description = description;
//	}
//
//
//
//	public String getModel() {
//		return model;
//	}
//
//
//
//	public void setModel(String model) {
//		this.model = model;
//	}
//
//
//
//	public String[] getElementNames() {
//		return elementNames;
//	}
//
//
//
//	public void setElementNames(String[] elementNames) {
//		this.elementNames = elementNames;
//	}
//
//
//
//	public String getFragmentPath() {
//		return fragmentPath;
//	}
//
//
//
//	public void setFragmentPath(String fragmentPath) {
//		this.fragmentPath = fragmentPath;
//	}
//
//
//
//	@Override
//	public String getExportedType() {
//		// TODO Auto-generated method stub
//		return RESOURCE_TYPE;
//	}
//
//}
