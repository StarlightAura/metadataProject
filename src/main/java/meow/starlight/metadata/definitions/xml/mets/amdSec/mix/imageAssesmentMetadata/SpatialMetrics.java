package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.spatialMetric.SamplingFrequency;

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
public class SpatialMetrics {

    @XmlElement(name = "mix:samplingFrequencyPlane")
    private String samplingFrequencyPlane;

    @XmlElement(name = "mix:samplingFrequencyUnit")
    private String samplingFrequencyUnit;

    @XmlElement(name = "mix:xSamplingFrequency")
    private SamplingFrequency xSamplingFrequency;

    @XmlElement(name = "mix:ySamplingFrequency")
    private SamplingFrequency ySamplingFrequency;

}
