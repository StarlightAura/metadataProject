module metadataProject {
    requires com.github.mjeanroy.exiftool;
    requires java.desktop;
    requires java.xml.bind;
    requires javafx.fxml;
    requires javafx.controls;
    requires static lombok;

    opens meow.starlight.metadata to javafx.fxml;
    exports meow.starlight.metadata.ui;
    exports meow.starlight.metadata;
}