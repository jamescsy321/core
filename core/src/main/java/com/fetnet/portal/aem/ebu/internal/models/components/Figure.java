package com.fetnet.portal.aem.ebu.internal.models.components;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import com.adobe.cq.export.json.ComponentExporter;

@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = { "ebu/components/figure" }
)

public class Figure extends com.fetnet.portal.aem.ebu.internal.core.models.components.Figure implements ComponentExporter{
    

    @Override
    public String getExportedType() {
        return "ebu/components/figure";
    }
}
