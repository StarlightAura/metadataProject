package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.imageColorEncoding.BitsPerSample;

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
public class ImageColorEncoding {

    @XmlElement(name = "mix:BitsPerSample")
    private BitsPerSample bitsPerSample;

    @XmlElement(name = "mix:samplesPerPixel")
    private int samplesPerPixel;
}
