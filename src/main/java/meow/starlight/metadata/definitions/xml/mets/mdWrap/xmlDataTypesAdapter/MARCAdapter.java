package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MARCXMLData;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MARCAdapter extends XmlAdapter<MARCXMLData, XMLData> {

    @Override
    public XMLData unmarshal(MARCXMLData marcxmlData) throws Exception {
        return marcxmlData;
    }

    @Override
    public MARCXMLData marshal(XMLData xmlData) throws Exception {
        return (MARCXMLData) xmlData;
    }
}
