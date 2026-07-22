module metadataProject {
    requires com.github.mjeanroy.exiftool;
    requires java.desktop;
    requires java.xml.bind;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires static lombok;
    requires com.opencsv;
    requires MaterialFX;

    opens meow.starlight.metadata to javafx.fxml;
    opens meow.starlight.metadata.ui to javafx.fxml;
    exports meow.starlight.metadata.ui;
    exports meow.starlight.metadata;
}