package com.fetnet.portal.aem.ebu.internal.models.components;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MapOneLoop {
	@ValueMapValue
	@Inject
	private String text;
	
	@ValueMapValue
	@Inject
	private String icon;
	
	@ValueMapValue
	@Inject
	private String link;
	

	public String getIcon() {
		return "chevron-right";
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLink() {
		return "#";
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
