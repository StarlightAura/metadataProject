package meow.starlight.metadata.parser;

import com.thebuzzmedia.exiftool.ExifTool;
import com.thebuzzmedia.exiftool.ExifToolBuilder;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class Parser {

    //this should be changed to be relative to the jar in the final build
    final ExifTool exifTool = new ExifToolBuilder().withPath("/home/aura/IDEAProjects/metadataProject/src/main/resources/lib/exiftool/exiftool").build();
    private static final String EXIFJSON = "-j";

    public void parseImages(String path){

        try (Stream<Path> paths = Files.walk( Paths.get( path ) )) {
            paths.filter(Files::isRegularFile)
                    .forEach(t -> {
                        try (FileWriter fw = new FileWriter( t.getFileName().toString() + ".txt" )){
                            List<String> ar = new ArrayList<>();
                            ar.add(EXIFJSON);
                            ar.add(String.valueOf(t));
                            System.out.println(exifTool.getImageMeta(t.toFile()).toString());
                            fw.write(exifTool.getRawExifToolOutput(ar));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
