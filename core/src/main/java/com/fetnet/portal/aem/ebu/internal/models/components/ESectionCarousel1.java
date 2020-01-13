package com.fetnet.portal.aem.ebu.internal.models.components;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.adobe.cq.export.json.ExporterConstants;

import javax.annotation.PostConstruct;

import javax.inject.Inject;

import com.adobe.cq.export.json.ComponentExporter;

@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = ESectionCarousel1.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class ESectionCarousel1 implements ComponentExporter {
    
    static final String RESOURCE_TYPE = "ebu/components/esectioncarousel1";
    

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String link;
    
  

	@ChildResource
	private List<Resource> card = new ArrayList<>();
	
	
    private List<ESectionCarousel1Roop>esectionCarousel1Roop = new ArrayList<>();


    public String getTitle() {
        return this.title;
    }
    public String getText() {
        return this.text;
    }
    public String getLink() {
        return this.link;
    }

   
	public List<ESectionCarousel1Roop> getESectionCarousel1Roop() {
		return esectionCarousel1Roop;
	}
     
    
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
    
    @PostConstruct
    protected void init(){
    	ESectionCarousel1Roop cardOne = new ESectionCarousel1Roop();
    	
    //  cardOne.setCardImage("");
    //  cardOne.setCardMeta("");
    //  cardOne.setCardTitle("");
    //  cardOne.setCardDescription("");


    	if(!card.isEmpty()) {
			for(Resource resource : card) {
				ESectionCarousel1Roop item = resource.adaptTo(ESectionCarousel1Roop.class);
				esectionCarousel1Roop.add(item);
			}
        }
        // else fetESectionCarousel1Roop.add(cardOne);
    }

}
