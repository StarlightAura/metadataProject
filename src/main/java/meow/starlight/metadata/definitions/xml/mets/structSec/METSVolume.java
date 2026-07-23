package meow.starlight.metadata.definitions.xml.mets.structSec;

import lombok.*;

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
public class METSVolume {

    @XmlAttribute(name = "TYPE")
    final private String type = "VOLUME";

    @XmlElement(name = "mets:div")
    private List<METSPage> metsPage;
}
