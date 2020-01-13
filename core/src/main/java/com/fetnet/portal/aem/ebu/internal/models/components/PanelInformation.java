package com.fetnet.portal.aem.ebu.internal.models.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;


@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = PanelInformation.RESOURCE_TYPE
)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class PanelInformation implements ComponentExporter{
	
	static final String RESOURCE_TYPE = "ebu/components/panelinformation";
	
	@ValueMapValue @Optional
	private String infoTitle;
	
	@ValueMapValue @Optional
	private String infoContent;
	
	@ChildResource @Optional
	public List<Resource> panelInformationList = new ArrayList<>();
	
	
	
	public String getInfoTitle() {
		return infoTitle;
	}

	public String getInfoContent() {
		return infoContent;
	}
	



	public List<Resource> getPanelInformationList() {
		return panelInformationList;
	}

	

	@Override
	public String getExportedType() {
		// TODO Auto-generated method stub
		return RESOURCE_TYPE;
	}

}
