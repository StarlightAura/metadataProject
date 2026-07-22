package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes;


import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Controlfield;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Datafield;

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
public class MARCRecord {

    @XmlElement(name = "marc:leader")
    private final String leader = "00000nmc a2200000 u 4500";

    @XmlElement(name = "marc:controlfield")
    @Singular
    List<Controlfield> controlfields;

    @XmlElement(name = "marc:datafield")
    @Singular
    List<Datafield> datafields;
}
