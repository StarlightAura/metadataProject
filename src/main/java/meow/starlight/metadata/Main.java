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
import meow.starlight.metadata.parser.NewAccessData;
import meow.starlight.metadata.parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

        // todo : check if paths exist, if not, log it
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss" + ".0")));
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
        List<NewAccessData> csvData = Parser.parseNewAccessData(args[1]);

        //parser.parseImageMetadata(args[0]);
        //parser.parseAccessData(args[1]);

        DirectoryProcessor dp = new DirectoryProcessor();

        dp.processDirectories(Parser.listDirectories(dir.listFiles()).stream()
                .map(Paths::get)
                .collect(Collectors.toList()), csvData);


    }



}