package com.fetnet.portal.aem.ebu.internal.models.components;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class TabTwoLoop{
	@ValueMapValue 
    @Inject
	private String metaTwo;
	
	@ValueMapValue 
	@Inject
	private String titleTwo;
	
	@ValueMapValue 
	@Inject
	private String descriptionTwo;

	public String getMetaTwo() {
		return metaTwo;
	}

	public void setMetaTwo(String metaTwo) {
		this.metaTwo = metaTwo;
	}

	public String getTitleTwo() {
		return titleTwo;
	}

	public void setTitleTwo(String titleTwo) {
		this.titleTwo = titleTwo;
	}

	public String getDescriptionTwo() {
		return descriptionTwo;
	}

	public void setDescriptionTwo(String descriptionTwo) {
		this.descriptionTwo = descriptionTwo;
	}
	
	
}


@Model(adaptables = SlingHttpServletRequest.class, adapters = {
		ComponentExporter.class }, resourceType = TabTwoList.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TabTwoList implements ComponentExporter{
	
	static final String RESOURCE_TYPE = "ebu/components/promotionArticle";
	
	@Optional
	@ChildResource
	private List<Resource> tabsTwoList = new ArrayList<>();
	
	@Optional
	private List<TabTwoLoop> tabTwo = new ArrayList<>();

	public List<TabTwoLoop> getTabTwo() {
		return tabTwo;
	}

	public void setTabTwo(List<TabTwoLoop> tabTwo) {
		this.tabTwo = tabTwo;
	}

	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}
	
	@PostConstruct
	protected void init() {
		TabTwoLoop emptyzero = new TabTwoLoop() ;
		emptyzero.setMetaTwo("");
		emptyzero.setTitleTwo("");
		emptyzero.setDescriptionTwo("");
		TabTwoLoop emptyone = new TabTwoLoop() ;
		emptyone.setMetaTwo("");
		emptyone.setTitleTwo("");
		emptyone.setDescriptionTwo("");
		TabTwoLoop emptytwo = new TabTwoLoop() ;
		emptytwo.setMetaTwo("");
		emptytwo.setTitleTwo("");
		emptytwo.setDescriptionTwo("");

		if (!tabsTwoList.isEmpty()) {
			for (Resource resource : tabsTwoList) {
				TabTwoLoop two = resource.adaptTo(TabTwoLoop.class);
				tabTwo.add(two);
			}
		}else tabTwo.add(emptyzero);
		tabTwo.add(emptyone); 
		tabTwo.add(emptytwo); 
	}

}
