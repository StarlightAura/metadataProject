package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData;

import lombok.*;
import lombok.experimental.SuperBuilder;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.XMLMIX;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypesAdapter.MIXAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder

@XmlAccessorType( XmlAccessType.FIELD )
@XmlJavaTypeAdapter(MIXAdapter.class)
@XmlRootElement(name = "mets:xmlData")
public class MIXXMLData extends XMLData {

    @XmlElement(name = "mix:mix")
    private XMLMIX xmlMIX;
}
