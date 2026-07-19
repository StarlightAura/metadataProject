package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.BasicDigitalObjectInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.BasicImageInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.ImageAssessmentMetadata;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.ImageCaptureMetadata;

import javax.xml.bind.annotation.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class XMLMIX {

    @XmlAttribute(name = "xsi:schemaLocation")
    String attr1 = "http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix20/mix20.xsd";

    @XmlAttribute(name = "xmlns:mix")
    String attr2 = "http://www.loc.gov/mix/v20";

    @XmlElement(name = "mix:BasicDigitalObjectInformation")
    private BasicDigitalObjectInformation basicDigitalObjectInformation;

    @XmlElement(name = "mix:BasicImageInformation")
    private BasicImageInformation basicImageInformation;

    @XmlElement(name = "mix:ImageCaptureMetadata")
    private ImageCaptureMetadata imageCaptureMetadata;

    @XmlElement(name = "mix:ImageAssessmentMetadata")
    private ImageAssessmentMetadata imageAssessmentMetadata;

}
