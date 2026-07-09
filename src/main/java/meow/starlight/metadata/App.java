package meow.starlight.metadata;

//jesus fucking christ just kill me already

import com.thebuzzmedia.exiftool.ExifTool;
import com.thebuzzmedia.exiftool.ExifToolBuilder;
import meow.starlight.metadata.definitions.MIX;
import meow.starlight.metadata.definitions.xml.XMLMETS;
import meow.starlight.metadata.definitions.xml.XMLMIX;
import meow.starlight.metadata.definitions.xml.mets.MetsHdr;
import meow.starlight.metadata.definitions.xml.mets.hdr.MetsAgent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



public class App {

    public static final String EXIFJSON = "-j";
    public static void main(String[] args) {

        try {
            mets();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }

    public static void exifTool() {
        String p = "/home/aura/work/project2/J_AHAJSE_AB5220_003";

        ExifTool exifTool = new ExifToolBuilder().withPath("/home/aura/IDEAProjects/metadataProject/src/main/resources/lib/exiftool/exiftool").build();


        try (Stream<Path> paths = Files.walk( Paths.get( p ) )) {
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

    public static void mets() throws JAXBException {
        JAXBContext jc;
        Marshaller ms;
        XMLMIX xmlmix = new XMLMIX();
        XMLMETS xmlmets = new XMLMETS();
        MetsHdr metsHdr = new MetsHdr();

        MetsAgent metsAgent1 = new MetsAgent();
        metsHdr.setAgent( metsAgent1 );

        //xmlmets.setXmlmix(xmlmix);
        xmlmets.setMetsHdr(metsHdr);





        jc = JAXBContext.newInstance(XMLMETS.class);
        ms = jc.createMarshaller();
        ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        ms.marshal(xmlmets, System.out);
        try {
            ms.marshal(xmlmets, new FileWriter("mets.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}