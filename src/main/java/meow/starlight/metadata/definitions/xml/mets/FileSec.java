package meow.starlight.metadata.definitions.xml.mets;

import lombok.*;
import meow.starlight.metadata.definitions.xml.mets.fileSec.FileGrp;

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
public class FileSec {

    @XmlAttribute(name = "ID")
    final private String id = "FILES1";

    @XmlElement(name = "mets:fileGrp")
    private FileGrp fileGrpJPG;

    @XmlElement(name = "mets:fileGrp")
    private FileGrp fileGrpTIF;

}
