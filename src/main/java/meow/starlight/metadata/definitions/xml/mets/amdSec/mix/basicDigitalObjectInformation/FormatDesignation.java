package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicDigitalObjectInformation;

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
public class FormatDesignation {

    @XmlElement(name = "mix:formatName")
    private String formatName;
}
