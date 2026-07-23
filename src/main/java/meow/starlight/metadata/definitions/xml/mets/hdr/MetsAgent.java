package meow.starlight.metadata.definitions.xml.mets.hdr;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class MetsAgent {

    @XmlAttribute(name = "TYPE")
    final private String type = "ORGANIZATION";

    @XmlAttribute(name = "ROLE")
    final private String creator = "CREATOR";

    @XmlElement(name = "mets:name")
    final private String name = "Archivo Histórico de la Armada Juan Sebastián de Elcano";
}
