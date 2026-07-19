package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicImageInformation;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.awt.color.ColorSpace;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class PhotometricInterpretation {

    @XmlElement(name = "mix:colorSpace")
    private String colorSpace;
}
