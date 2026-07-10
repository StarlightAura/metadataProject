package meow.starlight.metadata.definitions.xml.mets;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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

    @XmlElement(name = "mets:xmlData")
    private XMLData XMLData;
}
