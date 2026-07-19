package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.imageColorEncoding;

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
public class BitsPerSample {

    @XmlElement(name = "mix:bitsPerSampleValue")
    private int bitsPerSampleValue;

    @XmlElement(name = "mix:bitsPerSampleUnit")
    private String bitsPerSampleUnit;
}
