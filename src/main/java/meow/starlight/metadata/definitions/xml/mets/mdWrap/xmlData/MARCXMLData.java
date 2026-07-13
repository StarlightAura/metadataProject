package meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData;

import lombok.*;
import lombok.experimental.*;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.MARCRecord;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder

@XmlAccessorType( XmlAccessType.FIELD )
public class MARCXMLData extends XMLData {

    @XmlElementWrapper(name = "marc:collection")
    @XmlElement(name = "marc:record")
    @Singular
    private List<MARCRecord> records;

}
