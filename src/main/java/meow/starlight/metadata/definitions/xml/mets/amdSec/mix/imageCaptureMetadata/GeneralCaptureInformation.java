package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata;

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
public class GeneralCaptureInformation {

    @XmlElement(name = "mix:dateTimeCreated")
    private String dateTimeCreated;
}
