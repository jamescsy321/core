package com.fetnet.portal.aem.ebu.internal.models.components;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MapFourLoop {
	@ValueMapValue
	@Inject
	private String textFour;
	
	@ValueMapValue
	@Inject
	private String iconFour;
	
	@ValueMapValue
	@Inject
	private String linkFour;

	public String getText() {
		return textFour;
	}

	public void setText(String textFour) {
		this.textFour = textFour;
	}

	public String getIcon() {
		return "chevron-right";
	}

	public void setIcon(String iconFour) {
		this.iconFour = iconFour;
	}

	public String getLink() {
		return "#";
	}

	public void setLink(String linkFour) {
		this.linkFour = linkFour;
	}
	
}
