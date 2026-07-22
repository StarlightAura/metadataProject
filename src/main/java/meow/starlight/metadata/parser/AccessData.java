package meow.starlight.metadata.parser;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class AccessData {

    private String codigoClasificacion; // idk

    private String signaturaAntigua; // ONE (1) use. irrelevant.

    private String codigoReferencia; // this should denote either a full "collection" or individual images. but like. the full name of the image.

    private String titulo; // this goes to the MARC. somewhere.

    private String alcanceYContenido;

    private String fecha; // string bc data integrity is a myth and all the fucking dates are written differently. i'm not gonna write a parser for 2000 different formats.

    private String nombreProductor; // collection?

    private String nivelDescripcion; // this could be a Enum. Data integrity is a lie.

    private String volumenYSoporte; // oh lord.

    private String notas; // i think this one has somewhere to go

    private String observaciones;

    private String notaArchivero;

    private String tecnica; // this one is part of the marc records

    private String autor; // unclear, will be used regardless

    private String conservacion;

    private String fechaIngreso;

    private String formaIngreso;

    private String numRegistro; // unused.

    private String ID; // unused.
}
