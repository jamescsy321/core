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
        resourceType = ServiceEntry.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class ServiceEntry implements ComponentExporter {
    
    static final String RESOURCE_TYPE = "ebu/components/serviceentry";
    

    @ValueMapValue
    private String title;
    
  

	@ChildResource
	private List<Resource> card = new ArrayList<>();
	
	
    private List<ServiceEntryRoop>serviceEntryRoop = new ArrayList<>();


    public String getTitle() {
        return this.title;
    }

   
	public List<ServiceEntryRoop> getServiceEntryRoop() {
		return serviceEntryRoop;
	}
     
    
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
    
    @PostConstruct
    protected void init(){
    	ServiceEntryRoop cardOne = new ServiceEntryRoop();
    	
    //  cardOne.setCardImage("");
    //  cardOne.setCardMeta("");
    //  cardOne.setCardTitle("");
    //  cardOne.setCardDescription("");


    	if(!card.isEmpty()) {
			for(Resource resource : card) {
				ServiceEntryRoop item = resource.adaptTo(ServiceEntryRoop.class);
				serviceEntryRoop.add(item);
			}
        }
        // else horizontalCardsRoop.add(cardOne);
    }

}
