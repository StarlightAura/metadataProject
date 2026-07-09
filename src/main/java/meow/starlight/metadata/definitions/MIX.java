package meow.starlight.metadata.definitions;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

public class MIX {
// mix has a specific scheme defined here.
// if both .tif and .jpg exists, it would be favorable to get the metadata from the .jpg files
// as it is more abundant there for some reason
    Map<String, String> exifMD = new HashMap<>();

}
