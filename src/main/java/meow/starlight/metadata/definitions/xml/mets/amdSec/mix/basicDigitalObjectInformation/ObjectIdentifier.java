package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicDigitalObjectInformation;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class ObjectIdentifier {

    @XmlElement(name = "mix:objectIdentifierType")
   final private String mixObjectIdentifierType = "pathname";

    @XmlElement(name = "mix:objectIdentifierValue")
    private String mixObjectIdentifierValue;
}
