package meow.starlight.metadata.definitions.xml.mets.structSec;

import lombok.*;

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
public class METSPage {

    @XmlAttribute(name = "TYPE")
    private String type = "PAGE";

    @XmlAttribute(name = "ORDER")
    private String order; /// this should be the same as filegrp groupid

    @XmlElement(name = "mets:fptr")
    private FilePointer fptr;
}
