package meow.starlight.metadata.definitions.xml.mets.amdSec.rights;


import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.rights.rightsholder.RightsHolderContact;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class RightsHolder {

    @XmlElement(name = "rts:RightsHolderName")
    final private String RightsHolder = "Ministerio de Defensa – Archivo Histórico de la Armada";

    @XmlElement(name = "rts:RightsHolderContact")
    final private RightsHolderContact rightsHolderContact = RightsHolderContact.builder().build();
}
