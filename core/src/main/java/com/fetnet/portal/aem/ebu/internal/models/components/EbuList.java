package com.fetnet.portal.aem.ebu.internal.models.components;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;


@Model(
        adaptables = SlingHttpServletRequest.class, 
        adapters = {ComponentExporter.class}, 
        resourceType = {"ebu/components/ebulist"}
)

public class EbuList extends com.fetnet.portal.aem.ebu.internal.core.models.components.ListModel implements ComponentExporter{
    
   
    @Override
    public String getExportedType() {
        return "ebu/components/ebulist";
    }
}
