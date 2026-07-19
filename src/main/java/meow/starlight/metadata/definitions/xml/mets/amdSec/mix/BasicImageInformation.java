package meow.starlight.metadata.definitions.xml.mets.amdSec.mix;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicImageInformation.BasicImageCharacteristics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class BasicImageInformation {

    @XmlElement(name = "mix:BasicImageCharacteristics")
    private BasicImageCharacteristics basicImageCharacteristics;
}
