package com.fetnet.portal.aem.ebu.internal.models.components;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = ServiceTag.RESOURCE_TYPE
)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class ServiceTag implements ComponentExporter{
	
static final String RESOURCE_TYPE = "ebu/components/servicetag";

    @Optional
    @ValueMapValue	
    private String serviceTagTitle;
    
    @Optional
    @ChildResource
    public List<Resource> serviceTagList =new ArrayList<>();

    

	public String getServiceTagTitle() {
		return serviceTagTitle;
	}



	public void setServiceTagtitle(String serviceTagTitle) {
		this.serviceTagTitle = serviceTagTitle;
	}


	public List<Resource> getServiceTagList() {
		return serviceTagList;
	}



	public void setServiceTagList(List<Resource> serviceTagList) {
		this.serviceTagList = serviceTagList;
	}



	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}

   


}
