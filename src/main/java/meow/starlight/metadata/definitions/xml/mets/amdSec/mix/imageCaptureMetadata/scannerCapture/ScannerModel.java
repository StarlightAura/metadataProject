package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata.scannerCapture;

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
public class ScannerModel {

    @XmlElement(name = "mix:scannerModelName")
    private String scannerModelName;

    @XmlElement(name = "mix:scannerModelSerialNo")
    private String scannerModelSerialNo;
}
