package meow.starlight.metadata.definitions.xml.mets.amdSec.rights;


import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.rights.rightsholder.RightsHolderContact;

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
public class RightsHolder {

    @XmlElement(name = "rts:RightsHolderName")
    private String rtsRightsHolder = "Ministerio de Defensa – Archivo Histórico de la Armada";

    @XmlElement(name = "rts:RightsHolderContact")
    private RightsHolderContact rtsRightsHolderContact;
}
