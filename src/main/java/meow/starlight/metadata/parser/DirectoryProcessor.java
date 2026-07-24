package meow.starlight.metadata.parser;

import meow.starlight.metadata.builder.METSBuilder;
import meow.starlight.metadata.definitions.xml.XMLMETS;
import meow.starlight.metadata.definitions.xml.mets.AmdSec;
import meow.starlight.metadata.definitions.xml.mets.FileSec;
import meow.starlight.metadata.definitions.xml.mets.StructSec;
import meow.starlight.metadata.definitions.xml.mets.amdSec.RightsMD;
import meow.starlight.metadata.definitions.xml.mets.amdSec.TechMD;
import meow.starlight.metadata.definitions.xml.mets.fileSec.FileGrp;
import meow.starlight.metadata.definitions.xml.mets.fileSec.METSFile;
import meow.starlight.metadata.definitions.xml.mets.structSec.METSPage;
import meow.starlight.metadata.definitions.xml.mets.structSec.METSVolume;
import meow.starlight.metadata.definitions.xml.mets.structSec.StructMap;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryProcessor {

    /**
     * Processes files from specific subdirectories within a list of root paths.
     * @param parentDirectories List of root directories to process.
     */
    public void processDirectories(List<Path> parentDirectories) {
        for (Path parentDir : parentDirectories) {
            System.out.println("========================================");
            System.out.println("Processing Parent Directory: " + parentDir.toString());

            // 1. Identify all relevant subdirectories
            List<Path> targetDirs = findSubDirectories(parentDir, "M_", "J_");

            for (Path targetDir : targetDirs) {
                System.out.println("\n--- Processing Subdirectory: " + targetDir.getFileName());
                //TODO: add logic here to find if a directory has the same signature as one description in the .csv
                listAndProcessFiles(targetDir, targetDir);
            }


        }
    }

    /**
     * Finds all subdirectories within the parent directory that start with M_ or J_.
     */
    private List<Path> findSubDirectories(Path parentDir, String... prefixes) {
        try (Stream<Path> pathStream = Files.list(parentDir)) {
            return pathStream
                    .filter(Files::isDirectory) // Only directories
                    .filter(path -> {
                        String name = path.getFileName().toString();
                        for (String prefix : prefixes) {
                            if (name.startsWith(prefix)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error listing directory " + parentDir + ": " + e.getMessage());
            return List.of();
        }
    }

    /**
     * Lists and processes all files within a given subdirectory path.
     * TODO: this function should be responsible for both the fileSec and structMap logic
     */
    private void listAndProcessFiles(Path targetDir, Path parentDir) {
        List<TechMD> techMDList = new ArrayList<>();
        List<RightsMD> rightsMDList = new ArrayList<>();
        List<METSFile> jpgMetsFileList = new ArrayList<>();
        List<METSFile> tifMetsFileList = new ArrayList<>();
        List<METSPage> metsPageList = new ArrayList<>();

        try (Stream<Path> files = Files.list(targetDir)) {
            List<Path> filesToProcess = files
                    .filter(Files::isRegularFile)
                    .sorted()// Filter for actual files
                    .collect(Collectors.toList());

            System.out.println("Found " + filesToProcess.size() + " file(s).");

            // 2. Iterate and process each file individually
            for (Path file : filesToProcess) {
                //TODO: here should go a function that links each file to the fileSec and structMap
                parseFile(file, parentDir, techMDList, rightsMDList, jpgMetsFileList, tifMetsFileList, metsPageList);
            }
        } catch (IOException e) {
            System.err.println("Error accessing directory contents for " + targetDir + ": " + e.getMessage());
        }

        System.out.println("TechMD -> " + techMDList);
        System.out.println("Rights -> " + rightsMDList);
        AmdSec amdSec = AmdSec.builder().techMDs(techMDList).rightsMDs(rightsMDList).build();

        FileGrp jpgFileGrp = FileGrp.builder().id("JPG_SCANS").use("scans").files(jpgMetsFileList).build();
        FileGrp tifFileGrp = FileGrp.builder().id("TIF_SCANS").use("scans").files(tifMetsFileList).build();

        FileSec fileSec = FileSec.builder().fileGrpJPG(jpgFileGrp).fileGrpTIF(tifFileGrp).build();

        METSVolume metsVolume = METSVolume.builder().metsPages(metsPageList).build();
        StructMap structMap = StructMap.builder().metsVolume(metsVolume).build();
        StructSec structSec = StructSec.builder().structMap(structMap).build();

        /*
        System.out.println("FILEHDR -> " + METSBuilder.createHeader());
        System.out.println("AMDSEC -> " + amdSec);
        System.out.println("FILESEC -> " + fileSec);
        System.out.println("STRUCTSEC -> " + structSec);
       */

        XMLMETS xmlMETS = XMLMETS.builder()
                .metsHdr(METSBuilder.createHeader())
                //.dmdSec(dmdSec)
                .amdSec(amdSec)
                .fileSec(fileSec)
                .structSec(structSec)
                .build();
        System.out.println("XMLMETS -> " + xmlMETS);

        try {
            METSBuilder.mets(xmlMETS);
        } catch (JAXBException e) {
            System.err.println("Error creating mets file for " + targetDir + ": " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Placeholder method to perform individual file parsing logic.
     */


    /// TODO: insert parsing logic here to filter out tiffs.
    private void parseFile(Path filePath,Path parentDir,
                           List<TechMD> techMDList, List<RightsMD> rightsMDList,
                           List<METSFile> jpgMetsFileList, List<METSFile> tifMetsFileList,
                           List<METSPage> metsPageList){
        // Use Files.lines(filePath) to read line by line efficiently
        //System.out.println("Parsing file: " + filePath.getFileName());

        if(filePath.toString().endsWith(".tif")) {
            //System.out.println("Is a tif: " + filePath.getFileName());
            METSBuilder.processImage(filePath, parentDir, techMDList, rightsMDList, tifMetsFileList, metsPageList);
        }

        if(filePath.toString().endsWith(".jpeg") || filePath.toString().endsWith(".jpg")){

            METSBuilder.processImage(filePath, parentDir, techMDList, rightsMDList, jpgMetsFileList, metsPageList);
        }
    }
}