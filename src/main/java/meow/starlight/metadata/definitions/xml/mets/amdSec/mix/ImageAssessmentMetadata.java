package meow.starlight.metadata.definitions.xml.mets.amdSec.mix;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.ImageColorEncoding;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.SpatialMetrics;

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
public class ImageAssessmentMetadata {

    @XmlElement(name = "mix:SpatialMetrics")
    private SpatialMetrics spatialMetrics;

    @XmlElement(name = "mix:ImageColorEncoding")
    private ImageColorEncoding imageColorEncoding;
}
