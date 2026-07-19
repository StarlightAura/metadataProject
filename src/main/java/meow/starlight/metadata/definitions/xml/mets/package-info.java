@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(value = MARCAdapter.class, type = XMLData.class),
})
package meow.starlight.metadata.definitions.xml.mets;

import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter.MARCAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;