package meow.starlight.metadata.definitions.xml.mets;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class MDWrap {

    @XmlAttribute(name = "MDTYPE")
    private String mdType;

    @XmlAttribute(name = "OTHERMDTYPE")
    private String otherMDType;

    @XmlElement(name = "mets:xmlData")
    private XMLData XMLData;
}
