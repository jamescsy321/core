/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2018 Adobe Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package com.fetnet.portal.aem.ebu.internal.models.components;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerCardList {
	@ValueMapValue
	@Inject
	private String icon;
	
	@ValueMapValue
	@Inject
	private String focusIcon;
	
	@ValueMapValue
	@Inject
	private String label;
	
	@ValueMapValue
	@Inject
	private String imageMd;
	
	@ValueMapValue
	@Inject
	private String imageSm;
	
	@ValueMapValue
	@Inject
	private String bannerContext;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getimageMd() {
		return imageMd;
	}

	public void setimageMd(String imageMd) {
		this.imageMd = imageMd;
	}
	

	public String getFocusIcon() {
		return focusIcon;
	}

	public void setFocusIcon(String focusIcon) {
		this.focusIcon = focusIcon;
	}

	public String getImageSm() {
		return imageSm;
	}

	public void setImageSm(String imageSm) {
		this.imageSm = imageSm;
	}

	public String getBannerContext() {
		return bannerContext;
	}

	public void setBannerContext(String bannerContext) {
		this.bannerContext = bannerContext;
	}
	
	
	

}
