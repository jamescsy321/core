package com.fetnet.portal.aem.ebu.internal.models.components;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.export.json.ComponentExporter;

@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = DemoShop.RESOURCE_TYPE
)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class DemoShop implements ComponentExporter {
    
    static final String RESOURCE_TYPE = "ebu/components/demoshop";
    
   
    
    @ValueMapValue @Optional
    private String shopTitle;
    
    @Optional
    @ChildResource
    private List<Resource> demoShopCard = new ArrayList<>();
    @Optional
    private List<DemoShopCard> shopData = new ArrayList<>();
    
    
    
    

    public String getShopTitle() {
		return shopTitle;
	}



	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}



	public List<DemoShopCard> getShopData() {
		return shopData;
	}



	public void setShopData(ArrayList<DemoShopCard> shopData) {
		this.shopData = shopData;
	}



	@Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
	
	@PostConstruct
	protected void init() {
		DemoShopCard zero = new DemoShopCard() ;
		zero.setMeta("");
		zero.setBackground("");
		zero.setContent("");
		zero.setName("");
		zero.setLogo("");
		

		if (!demoShopCard.isEmpty()) {
			for (Resource resource : demoShopCard) {
				DemoShopCard data = resource.adaptTo(DemoShopCard.class);
				shopData.add(data);
			}
		}else shopData.add(zero);
		
	}

}