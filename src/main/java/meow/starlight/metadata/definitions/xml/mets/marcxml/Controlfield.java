package meow.starlight.metadata.definitions.xml.mets.marcxml;

import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class Controlfield {

    @XmlAttribute(name = "tag")
    private String tag;

    @XmlValue
    private String value;
}
