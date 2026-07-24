package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData;

import lombok.*;
import lombok.experimental.SuperBuilder;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.XMLRights;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter.RIGHTSAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder

@XmlAccessorType( XmlAccessType.FIELD )
@XmlJavaTypeAdapter(RIGHTSAdapter.class)
@XmlRootElement(name = "mets:xmlData")
public class RIGHTSXMLData extends XMLData {

    @XmlElement(name = "rts:RightsDeclarationMD")
    private XMLRights rights;
}
