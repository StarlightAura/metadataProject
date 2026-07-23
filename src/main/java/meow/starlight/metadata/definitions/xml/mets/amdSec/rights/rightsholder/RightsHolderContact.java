package meow.starlight.metadata.definitions.xml.mets.amdSec.rights.rightsholder;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class RightsHolderContact {

    @XmlElement(name = "rts:RightsHolderDesignation")
    final private String rightsHolderDesignation = "Ministerio de Defensa – Archivo Histórico de la Armada";

    @XmlElement(name = "rts:RightsHolderContactAddress")
    final private String rightsHolderContactAddress = "C/ Sanchidrián nº 9, 28024. Madrid";

    @XmlElement(name = "rts:RightsHolderContactPhone")
    final private String rightsHolderContactPhone = "+34 913059519";
}
