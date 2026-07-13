package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData;

import lombok.*;
import lombok.experimental.SuperBuilder;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.XMLMIX;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder

@XmlAccessorType( XmlAccessType.FIELD )
public class MIXXMLData extends XMLData {

    @XmlElement(name = "mix:mix")
    private XMLMIX xmlMIX;
}
