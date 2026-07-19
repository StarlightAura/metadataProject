package meow.starlight.metadata.definitions.xml.mets.fileSec;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class FLocat {

    @XmlAttribute(name = "LOCTYPE")
    private String loctype = "OTHER";

    @XmlAttribute(name = "xlink:href")
    private String href;
}
