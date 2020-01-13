package com.fetnet.portal.aem.ebu.internal.models.components;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsCardsRoop {
	
	@ValueMapValue 
	private String public_at;
	
	@ValueMapValue 
	private String cardMeta;

	
	@ValueMapValue 
	private String cardTitle;
	
	

    public String getPublic_at() {
		return public_at.substring(0, 10);
	}
    
    public String getMeta() {
		return cardMeta;
	}

    public String getTitle() {
		return cardTitle;
	}

	
	
	
}