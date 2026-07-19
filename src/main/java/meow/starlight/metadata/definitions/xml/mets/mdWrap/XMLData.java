
package meow.starlight.metadata.definitions.xml.mets.mdWrap;

import lombok.*;
import lombok.experimental.*;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MARCXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MIXXMLData;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder(toBuilder = true)

//@XmlAccessorType( XmlAccessType.FIELD )
@XmlSeeAlso({MARCXMLData.class, MIXXMLData.class})

public class XMLData {
}
