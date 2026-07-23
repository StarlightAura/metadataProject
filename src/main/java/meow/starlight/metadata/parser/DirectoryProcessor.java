package meow.starlight.metadata.parser;

import java.io.IOException;
import java.nio.file.*;
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
                listAndProcessFiles(targetDir);
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
     */
    private void listAndProcessFiles(Path targetDir) {
        try (Stream<Path> files = Files.list(targetDir)) {
            List<Path> filesToProcess = files
                    .filter(Files::isRegularFile) // Filter for actual files
                    .collect(Collectors.toList());

            System.out.println("Found " + filesToProcess.size() + " file(s).");

            // 2. Iterate and process each file individually
            for (Path file : filesToProcess) {
                parseFile(file);
            }
        } catch (IOException e) {
            System.err.println("Error accessing directory contents for " + targetDir + ": " + e.getMessage());
        }
    }

    /**
     * Placeholder method to perform individual file parsing logic.
     */


    /// TODO: insert parsing logic here to filter out tiffs.
    private void parseFile(Path filePath) {
        // Use Files.lines(filePath) to read line by line efficiently
        System.out.println("Parsing file: " + filePath.getFileName());

        if(filePath.toString().endsWith(".tif")) {
            System.out.println("Is a tif: " + filePath.getFileName());
        }
        //java.util.stream.Stream<String> lines = java.nio.file.Files.lines(filePath);
        long lineCount = 5;
        // Process lines using the Stream API...
        System.out.println("  -> Successfully read " + lineCount + " lines.");

    }
}