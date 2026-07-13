package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData;

import lombok.*;
import lombok.experimental.SuperBuilder;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder

@XmlAccessorType( XmlAccessType.FIELD )
public class PREMISXMLData extends XMLData {

    private String key;
}
