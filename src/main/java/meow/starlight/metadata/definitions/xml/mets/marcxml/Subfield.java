package meow.starlight.metadata.definitions.xml.mets.marcxml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class Subfield {

    @XmlAttribute(name = "code")
    private String code;

    @XmlValue
    private String subfield;
}
