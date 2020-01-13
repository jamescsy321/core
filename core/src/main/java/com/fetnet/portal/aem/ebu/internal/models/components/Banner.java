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

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.adobe.cq.export.json.ExporterConstants;

import javax.inject.Inject;

import com.adobe.cq.export.json.ComponentExporter;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {
		ComponentExporter.class }, resourceType = Banner.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class Banner implements ComponentExporter {

	static final String RESOURCE_TYPE = "ebu/components/banner";
	

	@Optional
	@ChildResource
	private List<Resource> bannerCard =new ArrayList<>();
	
	@Optional
	private List<BannerCardList> bannerList = new ArrayList<>();
	
	

	public List<BannerCardList> getBannerList() {
		return bannerList;
	}

	public void setBannerList(List<BannerCardList> bannerList) {
		this.bannerList = bannerList;
	}

	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}
	

	@PostConstruct
	protected void init() {
	
		BannerCardList BannerZero = new BannerCardList();
		BannerZero.setIcon("/resources/ebu/icons/ebu-micro.svg");
		BannerZero.setFocusIcon("/resources/ebu/icons/ebu-micro-focus.svg");
		BannerZero.setimageMd("/resources/ebu/images/banner/ebu-micro-banner.png");
		BannerZero.setImageSm("/resources/ebu/images/banner/ebu-micro-banner-sm.jpg");
		BannerZero.setBannerContext("");
		BannerZero.setLabel("");
		BannerCardList BannerOne = new BannerCardList();
		BannerOne.setIcon("/resources/ebu/icons/ebu-medium.svg");
		BannerOne.setFocusIcon("/resources/ebu/icons/ebu-micro-focus.svg");
		BannerOne.setimageMd("/resources/ebu/images/banner/ebu-micro-banner.png");
		BannerOne.setImageSm("/resources/ebu/images/banner/ebu-micro-banner-sm.jpg");
		BannerOne.setBannerContext("");
		BannerOne.setLabel("");

		BannerCardList BannerTwo = new BannerCardList();
		BannerTwo.setIcon("/resources/ebu/icons/ebu-micro.svg");
		BannerTwo.setFocusIcon("/resources/ebu/icons/ebu-medium-focus.svg");
		BannerTwo.setimageMd("/resources/ebu/images/banner/ebu-medium-banner.png");
		BannerTwo.setImageSm("/resources/ebu/images/banner/ebu-medium-banner-sm.jpg");
		BannerTwo.setBannerContext("");
		BannerTwo.setLabel("");
		
		BannerCardList BannerThree = new BannerCardList();
		BannerThree.setIcon("/resources/ebu/icons/ebu-micro.svg");
		BannerThree.setFocusIcon("/resources/ebu/icons/ebu-micro-focus.svg");
		BannerThree.setimageMd("/resources/ebu/images/banner/ebu-micro-banner.png");
		BannerThree.setImageSm("/resources/ebu/images/banner/ebu-micro-banner-sm.jpg");
		BannerThree.setBannerContext("");
		BannerThree.setLabel("");
		
		if(!bannerCard.isEmpty()) {
			for(Resource resource : bannerCard) {
				BannerCardList bcl = resource.adaptTo(BannerCardList.class);
				bannerList.add(bcl);
			}
		}
		else bannerList.add(BannerZero);
		bannerList.add(BannerOne);
		bannerList.add(BannerTwo);
		bannerList.add(BannerThree);
	}

}
