package meow.starlight.metadata.definitions.xml;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.MetsHdr;

import javax.xml.bind.annotation.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlRootElement(name = "mets:mets")
@XmlAccessorType( XmlAccessType.FIELD )
public class XMLMETS {

    @XmlAttribute(name = "xmlns:xlink")
    private String xlink = "http://www.w3.org/1999/xlink";
    @XmlAttribute(name = "xmlns:xsi")
    private String xsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name = "xsi:schemaLocation")
    private String xsiSchemaLocation = "http://www.loc.gov/METS/ http://www.loc.gov/standards/mets/mets.xsd";
    @XmlAttribute(name = "xmlns:mets")
    private String metsSchemaLocation = "http://www.loc.gov/METS/";

    //TODO: set up definitions for the header, dmdsec and amdsec.

    @XmlElement(name = "mets:metsHdr")
    private MetsHdr metsHdr;



    //@XmlElement(name = "mix:mix")
    //private XMLMIX xmlmix;

}
