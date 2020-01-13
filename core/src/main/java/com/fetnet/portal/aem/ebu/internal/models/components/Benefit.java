package com.fetnet.portal.aem.ebu.internal.models.components;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;
import com.adobe.cq.export.json.ExporterConstants;
import javax.inject.Inject;
import com.adobe.cq.export.json.ComponentExporter;

@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = Benefit.RESOURCE_TYPE
)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class Benefit implements ComponentExporter {
    
    static final String RESOURCE_TYPE = "ebu/components/benefit";

    
    @Optional
    @ValueMapValue
    @Inject
    private String datepicker;
    
    @Optional
    @ValueMapValue
    @Inject
    private String message;

    @Optional
    @ValueMapValue
    @Inject
    private String tabOneTitle;
    
    @Optional
    @ValueMapValue
    @Inject
    private Resource photo;
    
    
    @Optional
    @ValueMapValue
    @Inject
    private String subTitle;
    
    @Optional
    @ValueMapValue
    @Inject
    private String messageArea;
    
    @Optional
    @ValueMapValue
    @Inject
    private String imagePath;
    
    @Optional
    @ValueMapValue
    @Inject
    private String linkPath;
    
    
   

    public String getDatepicker() {
		return datepicker;
	}
	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }

    
    public String getTabonetitle() {
		return tabOneTitle;
	}
	public void setTabonetitle(String tabOneTitle) {
		this.tabOneTitle = tabOneTitle;
	}
	@Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
	public Resource getPhoto() {
		return photo;
	}
	public void setPhoto(Resource photo) {
		this.photo = photo;
	}
	public String getSubtitle() {
		return subTitle;
	}
	public void setSubtitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getMessagearea() {
		return messageArea;
	}
	public void setMessagearea(String messageArea) {
		this.messageArea = messageArea;
	}
	public String getImagepath() {
		return imagePath;
	}
	public void setImagepath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getLinkpath() {
		return linkPath;
	}
	public void setLinkpath(String linkPath) {
		this.linkPath = linkPath;
	}
	
	
    
	
    // @PostConstruct
    // protected void init(){
    // 	if(!promocard.isEmpty()) {
	// 		for(Resource resource : promocard) {
	// 			Promodescript ps = resource.adaptTo(Promodescript.class);
	// 			promodescriptList.add(ps);
	// 		}
	// 	}
    // }

}