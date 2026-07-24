package meow.starlight.metadata.definitions.xml.mets.marcxml;

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
public class Datafield {

    @XmlAttribute(name = "tag")
    private String tag;

    @XmlAttribute(name = "ind1")
    private String ind1;

    @XmlAttribute(name = "ind2")
    private String ind2;

    @XmlElement(name = "marc:subfield")
    @Singular
    private List<Subfield> subfields;
}
