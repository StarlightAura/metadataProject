package meow.starlight.metadata.builder;

import com.thebuzzmedia.exiftool.Tag;
import lombok.*;
import meow.starlight.metadata.definitions.xml.XMLMETS;
import meow.starlight.metadata.definitions.xml.mets.*;
import meow.starlight.metadata.definitions.xml.mets.amdSec.RightsMD;
import meow.starlight.metadata.definitions.xml.mets.amdSec.TechMD;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.BasicDigitalObjectInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.BasicImageInformation;
import meow.starlight.metadata.definitions.xml.mets.amdSec.mix.basicDigitalObjectInformation.ObjectIdentifier;
import meow.starlight.metadata.definitions.xml.mets.hdr.MetsAgent;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Controlfield;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Datafield;
import meow.starlight.metadata.definitions.xml.mets.marcxml.Subfield;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.XMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MARCXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlData.MIXXMLData;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.MARCRecord;
import meow.starlight.metadata.definitions.xml.mets.mdWrap.xmlDataTypes.XMLMIX;
import meow.starlight.metadata.parser.MIX;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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

    public static DmdSec createDmdSec(MDWrap mdwrap){
        return DmdSec.builder()
                .mdWrap(mdwrap)
                .build();
    }

    public static MDWrap createMDWrap(String mdType, String otherMDType, XMLData xmlData){
        return MDWrap.builder()
                .mdType(mdType)
                .otherMDType(otherMDType)
                .XMLData(xmlData)
                .build();
    }

    public static MARCXMLData createMARCXMLData(List<MARCRecord> records){
        return MARCXMLData.builder().records(records).build();
    }

    public static MARCRecord createMARCRecord(List<Controlfield> controlfields, List<Datafield> datafields) {
        return MARCRecord.builder().controlfields(controlfields).datafields(datafields).build();
    }

    public static Controlfield createControlfield(String tag, String value){
        return Controlfield.builder().tag(tag).value(value).build();
    }

    public static Datafield createDatafield(String tag, String ind1, String ind2, List<Subfield> subfields) {
        return Datafield.builder().tag(tag).ind1(ind1).ind2(ind2).subfields(subfields).build();
    }

    public static Subfield createSubfield(String code, String subfield) {
        return Subfield.builder().code(code).subfield(subfield).build();
    }

    ///////////////////////////////////

    public static AmdSec createAmdSec(List<TechMD> techMDs, List<RightsMD> rightsMDs){
        return AmdSec.builder().techMDs(techMDs).rightsMDs(rightsMDs).build();
    }

    public static TechMD createTechMD(String id, MDWrap mdwrap){
        return TechMD.builder().id(id).mdWrap(mdwrap).build();
    }

    public static MIXXMLData createMIXXMLData(XMLMIX xmlmix){
        return MIXXMLData.builder().xmlMIX(xmlmix).build();
    }

    public static XMLMIX createXMLMIX(Map<Tag, String> mix, String path){
        return XMLMIX.builder()
                .basicDigitalObjectInformation(BasicDigitalObjectInformation
                        .builder()
                        .objectIdentifier(ObjectIdentifier
                                .builder()
                                .mixObjectIdentifierType("pathname")
                                .mixObjectIdentifierValue("") //here goes the relative path to the .mets file. i'll do it tomorrow. i'm tired.
                                .build())
                        .build())
                .build();
    }

    public static RightsMD createRightsMD(String id, MDWrap mdwrap){
        return RightsMD.builder().id(id).mdWrap(mdwrap).build();
    }
}
