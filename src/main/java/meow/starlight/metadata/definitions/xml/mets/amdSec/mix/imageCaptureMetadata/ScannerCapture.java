package meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata.scannerCapture.ScannerModel;

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
public class ScannerCapture {

    @XmlElement(name = "mix:scannerManufacturer")
    private String scannerManufacturer;

    @XmlElement(name = "mix:ScannerModel")
    private ScannerModel scannerModel;
}
