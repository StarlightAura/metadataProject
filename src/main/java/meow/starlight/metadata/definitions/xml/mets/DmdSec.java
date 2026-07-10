package meow.starlight.metadata.definitions.xml.mets;

//this class is the "descriptive metadata section"
//aka: where the marc should go

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
public class DmdSec {

    @XmlAttribute(name = "ID")
    private String id = "DMD1";

    @XmlElement(name = "mets:mdWrap")
    private MDWrap mdWrap;
}
