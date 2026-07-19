package meow.starlight.metadata.definitions.xml.mets;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.structSec.StructMap;

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
public class StructSec {

    @XmlAttribute(name = "ID")
    private String id;

    @XmlElement(name = "mets:structMap")
    private StructMap structMap;
}
