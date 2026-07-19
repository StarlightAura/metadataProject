package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter;

import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MIXXMLData;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MIXAdapter extends XmlAdapter<MIXXMLData, XMLData> {
    @Override
    public XMLData unmarshal(MIXXMLData mixxmlData) throws Exception {
        return mixxmlData;
    }

    @Override
    public MIXXMLData marshal(XMLData xmlData) throws Exception {
        return (MIXXMLData) xmlData;
    }
}
