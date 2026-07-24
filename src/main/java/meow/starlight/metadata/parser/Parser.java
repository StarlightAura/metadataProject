package meow.starlight.metadata.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.thebuzzmedia.exiftool.ExifTool;
import com.thebuzzmedia.exiftool.ExifToolBuilder;
import com.thebuzzmedia.exiftool.Tag;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class Parser {

    public static final String COMMA_DELIMITER = ",";

    //this should be changed to be relative to the jar in the final build
    public final ExifTool exifTool = new ExifToolBuilder().withPath("src/main/resources/lib/exiftool/exiftool").build();
    private static final String EXIFJSON = "-j";
    final Type mapType = new TypeToken<List<Map<String, String>>>(){}.getType();
    public static final Gson gson = new Gson();
    /*
    public void parseImageMetadata(String path){
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
    */


    //this SHOULD return a map
    //this works. i don't know why this works. it works.
    //don't touch it unless explicitly required.
    public Map<String, String> parseImageMetadata(String path){
        var ref = new Object() {
            Map<String, String> metadata = new HashMap<>();
        };
        try (Stream<Path> paths = Files.walk(Paths.get(path))){
            paths.filter(Files::isRegularFile)
                    .forEach(file -> {
                                try {
                                    List<String> args = new ArrayList<>();
                                    args.add(EXIFJSON);
                                    args.add(String.valueOf(file));
                                    String jMetadata = exifTool.getRawExifToolOutput(args);
                                    Map<String, String> elMapa = orderJsonMetadata(jMetadata);

                                    //System.out.println(exifTool.getImageMeta(file.toFile()).toString());
                                    ref.metadata = elMapa;
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ref.metadata;
    }

    public static Map<String, String> orderJsonMetadata(String jsonInput) {
        Type listType = new com.google.gson.reflect.TypeToken<List<Map<String, String>>>() {
        }.getType();

        //@SuppressWarnings("unchecked")
        List<Map<String, String>> metadataList = gson.fromJson(jsonInput, listType);

        Map<String, String> finalMetadataMap = null;
        if (!metadataList.isEmpty()) {
            // Assuming the desired map is the first element in the array:
            finalMetadataMap = metadataList.get(0);

            //todo: replace with log
            //System.out.println("Successfully parsed " + finalMetadataMap.size() + " key-value pairs into a Map.");

            // Example of accessing an element (e.g., ImageWidth)
            //Object width = finalMetadataMap.get("ImageWidth");
            //System.out.println("Example Field (ImageWidth): " + width);
        } else {
            System.out.println("Error: Failed to parse the JSON or the list is empty.");
        }
        return finalMetadataMap;
    }

    //this is. definitely something.
    public void parseAccessData(String path){

        /*
        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        records.forEach(System.out::println);
         */


        /// todo: change this to use newAccessData
        List<AccessData> accessRecords = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(path));){
            while(csvReader.readNext() != null){
                String[] values = null;
                while ((values = csvReader.readNext()) != null) {
                    accessRecords.add(AccessData.builder()
                                    .codigoClasificacion(values[0])
                                    .signaturaAntigua(values[1])
                                    .codigoReferencia(values[2])
                                    .titulo(values[3])
                                    .alcanceYContenido(values[4])
                                    .fecha(values[5])
                                    .nombreProductor(values[6])
                                    .nivelDescripcion(values[7])
                                    .volumenYSoporte(values[8])
                                    .notas(values[9])
                                    .observaciones(values[10])
                                    .notaArchivero(values[11])
                                    .tecnica(values[12])
                                    .autor(values[13])
                                    .conservacion(values[14])
                                    .fechaIngreso(values[15])
                                    .formaIngreso(values[16])
                                    .numRegistro(values[17])
                                    .ID(values[18])
                            .build());
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("bruh");
            throw new RuntimeException(e);
        }
        System.out.println(accessRecords);
    }

    public void parseNewAccessData(String path){
        List<NewAccessData> newAccessRecords = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(path));){
            while(csvReader.readNext() != null){
                String[] values = null;
                while ((values = csvReader.readNext()) != null) {
                    newAccessRecords.add(NewAccessData.builder()
                            .signatura(values[0])
                            .titulo(values[1])
                            .alcanceYContenido(values[2])
                            .fecha(values[3])
                            .nombreProductor(values[4])
                            .nivelDescripcion(values[5])
                            .tipoDescripcion(values[6])
                            .volumenYSoporte(values[7])
                            .notes(values[8])
                            .observaciones(values[9])
                            .notaArchivero(values[10])
                            .tecnica(values[11])
                            .autor(values[12])
                            .autor(values[13])
                            .conservacion(values[14])
                            .fechaIngreso(values[15])
                            .formaIngreso(values[16])
                            .numRegistro(values[17])
                            .ID(values[18])
                            .build());
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    //we're gonna have to make some asumptions bc otherwise this project won't ever end.
    //repository containing directories "signatures" containing folders with tiff, jpegs and pdf
    //the mets file will be generated on the directory, alongside the image folders.

    public static List<String> listDirectories(File[] files){
        List<String> directories = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                System.out.println("Directory name: " + file.getName());

                directories.add(file.getAbsolutePath());
            }
        }
        return directories;
    }



}
