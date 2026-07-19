package meow.starlight.metadata.definitions.xml.mets.structSec;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class FilePointer {
    @XmlAttribute(name = "FILEID")
    private String fileid; /// this one should be the same as METSFILE.java ID
}
