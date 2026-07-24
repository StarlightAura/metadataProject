package meow.starlight.metadata.definitions.xml.mets.fileSec;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class FileGrp {

    @XmlAttribute(name = "ID")
    private String id;

    @XmlAttribute(name = "USE")
    private String use;

    @XmlElement(name = "mets:file")
    private List<METSFile> files;
}
