package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes;

import lombok.*;
import lombok.experimental.SuperBuilder;
import meow.starlight.metadata.definitions.xml.mets.amdSec.rights.RightsHolder;
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
public class XMLRights{

    @XmlAttribute(name = "RIGHTSCATEGORY")
    private String rightsCategory = "PUBLIC DOMAIN";

    @XmlElement(name = "rts:RightsDeclaration")
    private String rightsDeclaration = "Dominio público. Puede reutilizarse libremente, respetando la integridad de la obra y citando la procedencia: Archivo Histórico de la Armada – Ministerio de Defensa.";

    @XmlElement(name = "rts:RightsHolder")
    private RightsHolder rightsHolder;
}
