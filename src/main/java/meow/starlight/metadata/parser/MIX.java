package meow.starlight.metadata.parser;

import com.thebuzzmedia.exiftool.Tag;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.HashMap;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class MIX {
// mix has a specific scheme defined here.
// if both .tif and .jpg exists, it would be favorable to get the metadata from the .jpg files
// as it is more abundant there for some reason
    Map<Tag, String> exifMD;

    public static String get(Map<Tag, String> exif, String tag) {
        return exif
                .entrySet()
                .stream()
                .filter(entry -> tag.equals(entry.getKey().toString()))
                .map(Map.Entry::getValue)
                .findFirst()
                .get();

    }

}
