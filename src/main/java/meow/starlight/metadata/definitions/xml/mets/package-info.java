@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(value = MARCAdapter.class, type = XMLData.class),
        @XmlJavaTypeAdapter(value = MIXAdapter.class, type = XMLData.class),
        @XmlJavaTypeAdapter(value = RIGHTSAdapter.class, type = XMLData.class),
})
package meow.starlight.metadata.definitions.xml.mets;

import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter.MARCAdapter;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter.MIXAdapter;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter.RIGHTSAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;