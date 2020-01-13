package com.fetnet.portal.aem.ebu.internal.models.components;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
 

import javax.annotation.PostConstruct;
import com.adobe.cq.export.json.ExporterConstants;

 

import javax.inject.Inject;

import com.adobe.cq.export.json.ComponentExporter;

@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = SectionBanner3.RESOURCE_TYPE
)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class SectionBanner3 implements ComponentExporter {
    
    static final String RESOURCE_TYPE = "ebu/components/sectionbanner3";

    @Optional
    @ValueMapValue
    @Inject
    private String imagePath;

    @Optional
    @ValueMapValue
    @Inject
    private String imagePathSm;

    @Optional
    @ValueMapValue
    @Inject
    private String title;
    
    @Optional
    @ValueMapValue
    @Inject
    private String description;

    @Optional
    @ValueMapValue
    @Inject
    private String link;
    
 

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    
    

    public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
    public String getImagePathSm() {
		return imagePathSm;
	}
	public void setImagePathSm(String imagePathSm) {
		this.imagePathSm = imagePathSm;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
    
	@Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
    
    @PostConstruct
    protected void init(){
    }

}
