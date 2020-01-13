package com.fetnet.portal.aem.ebu.internal.models.components;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MapTwoLoop {
	@ValueMapValue
	@Inject
	private String textTwo;
	
	@ValueMapValue
	@Inject
	private String iconTwo;
	
	@ValueMapValue
	@Inject
	private String linkTwo;

	public String getText() {
		return textTwo;
	}

	public void setText(String textTwo) {
		this.textTwo = textTwo;
	}

	public String getIcon() {
		return "chevron-right";
	}

	public void setIcon(String iconTwo) {
		this.iconTwo = iconTwo;
	}

	public String getLink() {
		return "#";
	}

	public void setLink(String linkTwo) {
		this.linkTwo = linkTwo;
	}
	

	
}
