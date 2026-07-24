package meow.starlight.metadata.builder;

import com.google.common.io.Files;
import lombok.*;
import meow.starlight.metadata.definitions.xml.XMLMETS;
import meow.starlight.metadata.definitions.xml.mets.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.RightsMD;
import meow.starlight.metadata.definitions.xml.mets.amdSec.TechMD;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.BasicDigitalObjectInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.BasicImageInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.ImageAssessmentMetadata;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.ImageCaptureMetadata;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicDigitalObjectInformation.FormatDesignation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicDigitalObjectInformation.ObjectIdentifier;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicImageInformation.BasicImageCharacteristics;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicImageInformation.PhotometricInterpretation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.ImageColorEncoding;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.SpatialMetrics;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.imageColorEncoding.BitsPerSample;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageAssesmentMetadata.spatialMetric.SamplingFrequency;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata.GeneralCaptureInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata.ScannerCapture;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.imageCaptureMetadata.scannerCapture.ScannerModel;
import meow.starlight.metadata.definitions.xml.mets.amdSec.rights.RightsHolder;
import meow.starlight.metadata.definitions.xml.mets.fileSec.FLocat;
import meow.starlight.metadata.definitions.xml.mets.fileSec.METSFile;
import meow.starlight.metadata.definitions.xml.mets.hdr.MetsAgent;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Controlfield;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Datafield;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Subfield;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MARCXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MIXXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.RIGHTSXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.MARCRecord;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.XMLMIX;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.XMLRights;
import meow.starlight.metadata.definitions.xml.mets.structSec.FilePointer;
import meow.starlight.metadata.definitions.xml.mets.structSec.METSPage;
import meow.starlight.metadata.parser.MIX;
import meow.starlight.metadata.parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@XmlAccessorType( XmlAccessType.FIELD )
public class METSBuilder {

    static final public Parser parser = Parser.builder().build();

    public static void create(DmdSec dmdsec, AmdSec amdsec, FileSec filesec, StructSec structsec) {
        XMLMETS mets = XMLMETS.builder()
                .metsHdr(createHeader())
                .dmdSec(dmdsec)
                .amdSec(amdsec)
                .fileSec(filesec)
                .structSec(structsec)
                .build();
    }

    public static MetsHdr createHeader(){
        return MetsHdr.builder().agent(MetsAgent.builder().build()).build();
    }

    ///////////////////////////////////

    public static MDWrap createMDWrap(String mdType, String otherMDType, XMLData xmlData){
        return MDWrap.builder()
                .mdType(mdType)
                .otherMDType(otherMDType)
                .XMLData(xmlData)
                .build();
    }

    ///////////////////////////////////



    ///////////////////////////////////

    public static TechMD createTechMD(String id, MDWrap mdwrap){
        return TechMD.builder().id(id).mdWrap(mdwrap).build();
    }

    public static RightsMD createRightsMD(String id, MDWrap mdwrap){
        return RightsMD.builder().id(id).mdWrap(mdwrap).build();
    }

    ///////////////////////////////////

    public static MIXXMLData createMIXXMLData(XMLMIX xmlmix){
        return MIXXMLData.builder().xmlMIX(xmlmix).build();
    }

    public static XMLMIX createXMLMIX(Path filepath, Path parentdir, Map<String,String> metadata){
        return XMLMIX.builder()
                .basicDigitalObjectInformation(createBasicDigitalObjectInformation(filepath, parentdir, metadata))
                .basicImageInformation(createBasicImageInformation(metadata))
                .imageCaptureMetadata(createImageCaptureMetadata(metadata))
                .imageAssessmentMetadata(createImageAssessmentMetadata(metadata))
                .build();
    }

    ///////////////////////////////////

    public static BasicDigitalObjectInformation createBasicDigitalObjectInformation(Path filepath, Path parentdir, Map<String,String> metadata){

        ObjectIdentifier objectIdentifier = ObjectIdentifier.builder().mixObjectIdentifierValue("./" + parentdir.getFileName() + "/" + filepath.getFileName()).build();
        FormatDesignation formatDesignation = FormatDesignation.builder().formatName(MIX.get(metadata, "MIMEType")).build();
        long fileSize = filepath.toFile().length();
        String byteOrder = MIX.get(metadata, "ExifByteOrder");
        return BasicDigitalObjectInformation.builder().objectIdentifier(objectIdentifier)
                .formatDesignation(formatDesignation)
                .byteOrder(byteOrder)
                .fileSize(fileSize)
                .build();

    }

    public static BasicImageInformation createBasicImageInformation(Map<String,String> metadata){
        int imageWidth = Integer.parseInt(MIX.get(metadata, "ImageWidth"));
        int imageHeight = Integer.parseInt(MIX.get(metadata, "ImageHeight"));
        PhotometricInterpretation photometricInterpretation = PhotometricInterpretation.builder().colorSpace(MIX.get(metadata, "ColorSpaceData")).build();
        return BasicImageInformation.builder()
                .basicImageCharacteristics(BasicImageCharacteristics.builder()
                        .imageWidth(imageWidth)
                        .imageHeight(imageHeight)
                        .photometricInterpretation(photometricInterpretation)
                        .build())
                .build();
    }

    public static ImageCaptureMetadata createImageCaptureMetadata(Map<String,String> metadata){
        GeneralCaptureInformation generalCaptureInformation = GeneralCaptureInformation.builder().dateTimeCreated(metadata.get("FileModifyDate")).build();
        ScannerCapture scannerCapture = ScannerCapture.builder().scannerManufacturer(metadata.get("Make")).scannerModel(
                ScannerModel.builder().scannerModelName(metadata.get("Model")).scannerModelSerialNo(metadata.get("Model")).build()
        ).build();
        return ImageCaptureMetadata.builder().generalCaptureInformation(generalCaptureInformation).scannerCapture(scannerCapture).build();
    }

    public static ImageAssessmentMetadata createImageAssessmentMetadata(Map<String,String> metadata){
        SpatialMetrics spatialMetrics = SpatialMetrics.builder().samplingFrequencyPlane("object plane").samplingFrequencyUnit(metadata.get("ResolutionUnit"))
                .xSamplingFrequency(SamplingFrequency.builder().numerator(Integer.parseInt(metadata.get("XResolution"))).denominator(1).build())
                .ySamplingFrequency(SamplingFrequency.builder().numerator(Integer.parseInt(metadata.get("YResolution"))).denominator(1).build())
                .build();
        int bitsPerSample = Integer.parseInt(metadata.get("BitsPerSample").split(" ")[0]);
        int samplesPerPixel = 0;
        if((metadata.get("SamplesPerPixel") == null)){
            samplesPerPixel = 0;
        }
        if((metadata.get("SamplesPerPixel") != null)){
            samplesPerPixel = Integer.parseInt(metadata.get("SamplesPerPixel"));
        }
        ImageColorEncoding imageColorEncoding = ImageColorEncoding.builder().bitsPerSample(
                BitsPerSample.builder().bitsPerSampleValue(bitsPerSample).bitsPerSampleUnit("integer").build())
                .samplesPerPixel(samplesPerPixel)
                .build();
        return ImageAssessmentMetadata.builder().spatialMetrics(spatialMetrics).imageColorEncoding(imageColorEncoding).build();
    }

    ///////////////////////////////////

    public static RIGHTSXMLData createRIGHTSXMLData(){
        return RIGHTSXMLData.builder().rights(createXMLRights()).build();
    }

    public static XMLRights createXMLRights(){
        return XMLRights.builder().rightsHolder(createRightsHolder()).build();
    }

    public static RightsHolder createRightsHolder(){
        return RightsHolder.builder().build();
    }

    ///////////////////////////////////

    public static METSFile createMETSFile(Path filepath, Path parentdir, String filename, Map<String,String> metadata){
        return METSFile.builder()
                .amdid("TMD_MIX_" + filename)
                .id("id_" + filename)
                .mimeType(MIX.get(metadata, "MIMEType"))
                .size(filepath.toFile().length())
                .fLocat(createFLocat(filepath, parentdir))
                .build();
    }

    public static FLocat createFLocat(Path filepath, Path parentdir){
        return FLocat.builder().href("./" + parentdir.getFileName() + "/" + filepath.getFileName()).build();
    }

    ///////////////////////////////////

    public static METSPage createMETSPage(String filename){
        return METSPage.builder().order(filename).fptr(createFilePointer(filename)).build();
    }

    public static FilePointer createFilePointer(String filename){
        return FilePointer.builder().fileid("id_" + filename).build();
    }

    ///////////////////////////////////

    public static void processImage(Path filepath, Path parentdir,
                                    List<TechMD> techMDList, List<RightsMD> rightsMDList,
                                    List<METSFile> metsFileList,
                                    List<METSPage> metsPageList){

        Map<String,String> metadata = parser.parseImageMetadata(filepath.toString());
        String filename = Files.getNameWithoutExtension(filepath.getFileName().toString());
        //System.out.println("Metadata: " + metadata);


        MIXXMLData xmlmix = createMIXXMLData(createXMLMIX(filepath, parentdir, metadata));
        MDWrap techMDWrap = createMDWrap("NISOIMG", "", xmlmix);
        TechMD techMD = createTechMD("TMD_MIX_" + filename, techMDWrap);
        techMDList.add(techMD);


        MDWrap rightsMDWrap = createMDWrap("METSRIGHTS", "", createRIGHTSXMLData());
        RightsMD rightsMD = createRightsMD("RMD_RTS_" + filename, rightsMDWrap);
        rightsMDList.add(rightsMD);


        METSFile metsFile = createMETSFile(filepath, parentdir, filename, metadata);
        metsFileList.add(metsFile);


        METSPage metsPage = createMETSPage(filename);
        metsPageList.add(metsPage);
    }


    public static void mets(XMLMETS xmlmets) throws JAXBException {


        JAXBContext jc;
        Marshaller ms;
        //from here on downwards it's conceptual, not final

        //XMLMIX xmlmix = new XMLMIX();
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
