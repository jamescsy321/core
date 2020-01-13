package com.fetnet.portal.aem.ebu.internal.models.components;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MapThreeLoop {
	@ValueMapValue
	@Inject
	private String textThree;
	
	@ValueMapValue
	@Inject
	private String iconThree;
	
	@ValueMapValue
	@Inject
	private String linkThree;

	public String getText() {
		return textThree;
	}

	public void setText(String textThree) {
		this.textThree = textThree;
	}

	public String getIcon() {
		return "chevron-right";
	}

	public void setIcon(String iconThree) {
		this.iconThree = iconThree;
	}

	public String getLink() {
		return "#";
	}

	public void setLink(String linkThree) {
		this.linkThree = linkThree;
	}
	
}
