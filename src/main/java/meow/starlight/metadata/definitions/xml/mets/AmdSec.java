package meow.starlight.metadata.definitions.xml.mets;


import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.RightsMD;
import meow.starlight.metadata.definitions.xml.mets.amdSec.TechMD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class AmdSec {

    @XmlAttribute(name = "ID")
    private String id = "AMD1";

    @XmlElement(name = "mets:techMD")
    @Singular
    private List<TechMD> techMDs;

    @XmlElement(name = "mets:rightsMD")
    @Singular
    private List<RightsMD> rightsMDs;
}
