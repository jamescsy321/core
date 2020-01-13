package com.fetnet.portal.aem.ebu.internal.models.components;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fetnet.portal.aem.ebu.internal.models.HelloWorld;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {ComponentExporter.class},
 resourceType = { "ebu/components/content/custom/contentimagesection", "ebu/components/contentimagesection", "ebu-internal/components/content/custom/contentimagesection" })
@Exporter(name = "jackson", extensions = { "json" })
public class ESectionList implements ComponentExporter{
	static final String RESOURCE_TYPE = "ebu/components/esectionlist";

    @Inject @Optional
    private String title;
    
    @Inject @Optional
    private String image;
    
    @Inject @Optional
    List<Resource> list;
    
    @Inject @Optional
    private String type;
    
    @Inject @Optional
    private String prefixIcon;

    @Inject @Optional
    private String layout;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<Resource> getList() {
        if(list == null)
            list = new ArrayList();
        return list;
    }

    public String getType() {
        return type;
    }

    public String getPrefixIcon() {
        return prefixIcon;
    }

    public String getLayout() {
        return layout;
    }

	@Override
	public String getExportedType() {
		// TODO Auto-generated method stub
		return RESOURCE_TYPE;
	}
}