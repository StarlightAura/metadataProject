package meow.starlight.metadata;

//jesus fucking christ just kill me already

import com.thebuzzmedia.exiftool.ExifTool;
import com.thebuzzmedia.exiftool.ExifToolBuilder;
import meow.starlight.metadata.definitions.xml.XMLMETS;
import meow.starlight.metadata.definitions.xml.XMLMIX;
import meow.starlight.metadata.definitions.xml.mets.DmdSec;
import meow.starlight.metadata.definitions.xml.mets.MDWrap;
import meow.starlight.metadata.definitions.xml.mets.MetsHdr;
import meow.starlight.metadata.definitions.xml.mets.hdr.MetsAgent;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Controlfield;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Datafield;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.MARCXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.MARCRecord;

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
        //from here on downwards it's conceptual, not final

        //XMLMIX xmlmix = new XMLMIX();
        XMLMETS xmlmets = new XMLMETS();

        MetsHdr metsHdr = new MetsHdr();

        DmdSec dmdSec = new DmdSec();

        MARCRecord marcRecord = MARCRecord.builder().leader("00000cam a22000005i 4500").controlfield(
                Controlfield.builder().tag("001").value("Controlfield").build()
        )
                .controlfield(Controlfield.builder().tag("002").value("Controlfield").build())
                .datafield(Datafield.builder().tag("040").ind2(" ").ind1(" ").build())
                .build();
        MARCXMLData marcXMLData = MARCXMLData.builder().record(marcRecord).build();

        MDWrap mdWrap = MDWrap.builder().mdType("MARC").XMLData(marcXMLData).build();

        dmdSec.setMdWrap(mdWrap);

        MetsAgent metsAgent1 = new MetsAgent();
        metsHdr.setAgent( metsAgent1 );

        //xmlmets.setXmlmix(xmlmix);
        xmlmets.setMetsHdr(metsHdr);
        xmlmets.setDmdSec( dmdSec );



        //from here on upwards its conceptual, not final
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