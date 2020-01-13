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
		ComponentExporter.class }, resourceType = PromotionArticle.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class PromotionArticle implements ComponentExporter {

	static final String RESOURCE_TYPE = "ebu/components/promotionArticle";
	@Optional
	@ValueMapValue
	@Inject
	private String proTitle;

	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}

	public String getProTitle() {
		return this.proTitle;
	}

	@Optional
	@ChildResource
	private List<Resource> promoArtList = new ArrayList<>();

	@Optional
	private List<PromoArtList> data = new ArrayList<>();

	public List<PromoArtList> getData() {
		return data;
	}

	public void setData(List<PromoArtList> data) {
		this.data = data;
	}

	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}

	@PostConstruct
	protected void init() {
		PromoArtList emptyzero = new PromoArtList() ;
		emptyzero.setMeta("");
		emptyzero.setImage("");
		emptyzero.setTitle("");
		emptyzero.setDescription("");
		PromoArtList emptyone = new PromoArtList() ;
		emptyone.setMeta("");
		emptyone.setImage("");
		emptyone.setTitle("");
		emptyone.setDescription("");
		PromoArtList emptytwo = new PromoArtList() ;
		emptytwo.setMeta("");
		emptytwo.setImage("");
		emptytwo.setTitle("");
		emptytwo.setDescription("");

		if (!promoArtList.isEmpty()) {
			for (Resource resource : promoArtList) {
				PromoArtList pal = resource.adaptTo(PromoArtList.class);
				data.add(pal);
			}
		}else data.add(emptyzero);
		data.add(emptyone); 
		data.add(emptytwo); 
	}
}
