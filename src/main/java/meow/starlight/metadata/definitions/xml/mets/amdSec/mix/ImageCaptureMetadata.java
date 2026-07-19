package meow.starlight.metadata.definitions.xml.mets.amdSec.mix;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata.GeneralCaptureInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata.ScannerCapture;

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
public class ImageCaptureMetadata {

    @XmlElement(name = "mix:GeneralCaptureInformation")
    private GeneralCaptureInformation generalCaptureInformation;

    @XmlElement(name = "mix:ScannerCapture")
    private ScannerCapture scannerCapture;
}
