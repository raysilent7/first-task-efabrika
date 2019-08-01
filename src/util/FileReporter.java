package util;

import entities.MyFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

public class FileReporter {

    public void fileReporter (Path savePath, List<MyFile> myFiles) {
        for (MyFile file : myFiles) {
            try (BufferedWriter writer = Files.newBufferedWriter(savePath, CREATE, APPEND, WRITE)) {

                writer.write(file.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
