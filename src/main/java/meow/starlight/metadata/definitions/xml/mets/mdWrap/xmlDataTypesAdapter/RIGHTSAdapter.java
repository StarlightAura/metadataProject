package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter;

import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.RIGHTSXMLData;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class RIGHTSAdapter extends XmlAdapter<RIGHTSXMLData, XMLData> {
    @Override
    public XMLData unmarshal(RIGHTSXMLData rightsxmlData) throws Exception {
        return rightsxmlData;
    }

    @Override
    public RIGHTSXMLData marshal(XMLData xmlData) throws Exception {
        return (RIGHTSXMLData) xmlData;
    }
}
