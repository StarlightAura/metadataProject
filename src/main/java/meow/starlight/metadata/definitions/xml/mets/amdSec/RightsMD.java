package meow.starlight.metadata.definitions.xml.mets.amdSec;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.MDWrap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class RightsMD {

    @XmlAttribute(name = "ID")
    private String id; //TODO: make this attribute get its ID at runtime from the file
    //"RMD_MIX_" + id

    @XmlElement(name = "mets:mdWrap")
    private MDWrap mdWrap;
}
