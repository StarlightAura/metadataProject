package meow.starlight.metadata.definitions.xml.mets.fileSec;

import lombok.*;

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
public class METSFile {

    @XmlAttribute(name = "MDID")
    private String amdid;

    @XmlAttribute(name = "ID")
    private String id;

    @XmlAttribute(name = "MIMETYPE")
    private String mimeType;

    @XmlAttribute(name = "SIZE")
    private long size;

    @XmlElement(name = "mets:FLocat")
    private FLocat fLocat;
}
