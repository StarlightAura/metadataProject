package meow.starlight.metadata.definitions.xml.mets.amdSec.mix;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicDigitalObjectInformation.FormatDesignation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicDigitalObjectInformation.ObjectIdentifier;

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
public class BasicDigitalObjectInformation {

    @XmlElement(name = "mix:ObjectIdentifier")
    private ObjectIdentifier objectIdentifier;

    @XmlElement(name = "mix:fileSize")
    private long fileSize;

    @XmlElement(name = "mix:FormatDesignation")
    private FormatDesignation formatDesignation;

    @XmlElement(name = "mix:byteOrder")
    private String byteOrder;
}
