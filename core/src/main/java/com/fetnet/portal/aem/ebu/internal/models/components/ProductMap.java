package com.fetnet.portal.aem.ebu.internal.models.components;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
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
        resourceType = ProductMap.RESOURCE_TYPE
)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class ProductMap implements ComponentExporter{
	
static final String RESOURCE_TYPE = "ebu/components/productmap";



   @ValueMapValue
   @Optional
   private String masterTitle;
   
   @ValueMapValue
   @Optional
   private String titleOne;
   
   @ValueMapValue
   @Optional
   private String titleTwo;
   
   @ValueMapValue
   @Optional
   private String titleThree;
   
   @ValueMapValue
   @Optional
   private String titleFour;
   
   @Optional
   @ChildResource
   private List<Resource> tabOneContent = new ArrayList<>();
   
   
   
   @Optional
   @ChildResource
   private List<Resource> tabTwoContent = new ArrayList<>();
   
   
   @Optional
   @ChildResource
   private List<Resource> tabThreeContent = new ArrayList<>();
  
   @Optional
   @ChildResource
   private List<Resource> tabFourContent = new ArrayList<>();
   
   
    

    public String getMasterTitle() {
	return masterTitle;
}

public void setMasterTitle(String masterTitle) {
	this.masterTitle = masterTitle;
}

	public String getTitleOne() {
	return titleOne;
}

public void setTitleOne(String titleOne) {
	this.titleOne = titleOne;
}

	public String getTitleTwo() {
	return titleTwo;
}

public String getTitleThree() {
		return titleThree;
	}

	public void setTitleThree(String titleThree) {
		this.titleThree = titleThree;
	}

	public String getTitleFour() {
		return titleFour;
	}

	public void setTitleFour(String titleFour) {
		this.titleFour = titleFour;
	}

public void setTitleTwo(String titleTwo) {
	this.titleTwo = titleTwo;
}


	public List<Resource> getTabOneContent() {
	return tabOneContent;
}


public List<Resource> getTabTwoContent() {
	return tabTwoContent;
}



public List<Resource> getTabThreeContent() {
	return tabThreeContent;
}



public List<Resource> getTabFourContent() {
	return tabFourContent;
}



	@Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
    

}
