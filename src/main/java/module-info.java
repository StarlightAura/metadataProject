module metadataProject {
    requires com.github.mjeanroy.exiftool;
    requires java.desktop;
    requires java.xml.bind;
    requires javafx.fxml;
    requires javafx.graphics;
    requires static lombok;

    opens meow.starlight.metadata;
}