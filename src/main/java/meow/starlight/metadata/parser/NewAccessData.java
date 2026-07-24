package meow.starlight.metadata.parser;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class NewAccessData {

    private String signatura; // complete signature so it matches the folders.

    private String titulo; // title for MARC

    private String alcanceYContenido; // unused. legacy

    private String fecha; // date in the SINGLE YEAR format

    private String nombreProductor; // unused. legacy

    private String nivelDescripcion; // unused. legacy. // marc datafield 338

    private String tipoDescripcion; // image or text. IMAGE. OR. TEXT.

    private String volumenYSoporte; // sigh. nº de páginas; tipo de medio físico; dimensiones; unidad

    private String notes; // unused. legacy

    private String observaciones; // unused. legacy

    private String notaArchivero; // unused. legacy

    private String tecnica; // unused? i can't find anywhere it fits

    private String autor; // essential for marc field 100. AUTHOR OF ORIGINAL PIECE

    private String conservacion; // unused. legacy

    private String fechaIngreso; // unused. legacy

    private String formaIngreso; // unused. legacy

    private String numRegistro; // unused. legacy

    private String ID; //unused. legacy
}
