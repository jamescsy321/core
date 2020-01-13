package com.fetnet.portal.aem.ebu.internal.models.components;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ESectionCarousel1Roop {
	
	@ValueMapValue 
	private String cardImage;
	
	@ValueMapValue 
	private String cardMeta;

	
	@ValueMapValue 
	private String cardTitle;
	
	@ValueMapValue 
	private String cardDescription;


	

    public String getImage() {
		return cardImage;
	}
    
    public String getMeta() {
		return cardMeta;
	}

    public String getTitle() {
		return cardTitle;
	}
    
    public String getDescription() {
    	return cardDescription;
	}
	
	
	
}