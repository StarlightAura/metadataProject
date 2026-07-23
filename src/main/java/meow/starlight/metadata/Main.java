package meow.starlight.metadata;

//jesus fucking christ just kill me already

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import meow.starlight.metadata.builder.METSBuilder;
import meow.starlight.metadata.definitions.xml.XMLMETS;
import meow.starlight.metadata.definitions.xml.mets.DmdSec;
import meow.starlight.metadata.definitions.xml.mets.MDWrap;
import meow.starlight.metadata.definitions.xml.mets.MetsHdr;
import meow.starlight.metadata.definitions.xml.mets.amdSec.rights.RightsHolder;
import meow.starlight.metadata.definitions.xml.mets.amdSec.rights.rightsholder.RightsHolderContact;
import meow.starlight.metadata.definitions.xml.mets.hdr.MetsAgent;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Controlfield;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Datafield;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MARCXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.MARCRecord;
import meow.starlight.metadata.parser.DirectoryProcessor;
import meow.starlight.metadata.parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;



public class Main {


    /// two args. first is the repository directory.
    /// second one is the .csv file.
    /// i'd pray for god to help me.
    /// but there is no god.
    public static void main(String[] args) {
        parse(args);
    }

    /*
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("App.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Starlight Metadata");
        primaryStage.show();
    }
    */


    public static void parse(String[] args) {
        File dir = new File(args[0]);

        //parser.parseImageMetadata(args[0]);
        //parser.parseAccessData(args[1]);

        DirectoryProcessor dp = new DirectoryProcessor();

        dp.processDirectories(Parser.listDirectories(dir.listFiles()).stream()
                .map(Paths::get)
                .collect(Collectors.toList()));


    }

    public static void mets() throws JAXBException {


        JAXBContext jc;
        Marshaller ms;
        //from here on downwards it's conceptual, not final

        //XMLMIX xmlmix = new XMLMIX();
        XMLMETS xmlmets = new XMLMETS();

        MetsHdr metsHdr = new MetsHdr();

        DmdSec dmdSec = new DmdSec();

        MARCRecord marcRecord = MARCRecord.builder().controlfield(
                Controlfield.builder().tag("001").value("Controlfield").build()
        )
                .controlfield(Controlfield.builder().tag("002").value("Controlfield").build())
                .datafield(Datafield.builder().tag("040").ind2(" ").ind1(" ").build())
                .build();
        XMLData marcXMLData = MARCXMLData.builder().record(marcRecord).build();

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