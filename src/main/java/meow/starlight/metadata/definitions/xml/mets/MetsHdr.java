package meow.starlight.metadata.definitions.xml.mets;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.hdr.MetsAgent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class MetsHdr {

    @XmlAttribute(name = "CREATEDATE")
    final private String createDate = OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

    @XmlAttribute(name = "RECORDSTATUS")
    final private String recordStatus = "Complete";

    @XmlElement(name = "mets:agent")
    private MetsAgent agent;

}
