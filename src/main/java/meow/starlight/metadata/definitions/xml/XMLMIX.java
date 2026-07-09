package meow.starlight.metadata.definitions.xml;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@XmlAccessorType( XmlAccessType.FIELD )
public class XMLMIX {

    @XmlAttribute(name = "xsi:schemaLocation")
    String attr1 = "http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix20/mix20.xsd";

    @XmlAttribute(name = "xmlns:mix")
    String attr2 = "http://www.loc.gov/mix/v20";

}
