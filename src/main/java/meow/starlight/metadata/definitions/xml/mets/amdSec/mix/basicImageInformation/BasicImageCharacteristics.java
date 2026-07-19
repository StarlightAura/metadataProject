package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicImageInformation;

import lombok.*;

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
public class BasicImageCharacteristics {

    @XmlElement(name = "mix:imageWidth")
    private int imageWidth;

    @XmlElement(name = "mix:imageHeight")
    private int imageHeight;

    @XmlElement(name = "mix:PhotometricInterpretation")
    private PhotometricInterpretation photometricInterpretation;
}
