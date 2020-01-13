package com.fetnet.portal.aem.ebu.internal.models.components;


import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoShopCard{
	
@ValueMapValue 
@Inject
private String logo;
@ValueMapValue 
@Inject
private String logoWhite;
@ValueMapValue 
@Inject
private String background;
@ValueMapValue 
@Inject
private String name;
@ValueMapValue 
@Inject
private String meta;
@ValueMapValue 
@Inject
private String content;

public String getBackground() {
	return background;
}
public void setBackground(String background) {
	this.background = background;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public String getLogoWhite() {
	return logoWhite;
}
public void setLogoWhite(String logoWhite) {
	this.logoWhite = logoWhite;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMeta() {
	return meta;
}
public void setMeta(String meta) {
	this.meta = meta;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}



}