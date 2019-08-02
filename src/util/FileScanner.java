package util;

import entities.MyFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileScanner {

    public static List<MyFile> doScan(Path path) {
        List<MyFile> myFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(path)){

            List<String> files = walk.map(x -> x.toString()).collect(Collectors.toList());

            for (String file : files) {

                File newFile = new File (file);
                myFiles.add(new MyFile(newFile.getName(), newFile.getParent(), Files.size(newFile.toPath()), ((FileTime)Files.getAttribute(newFile.toPath(), "basic:creationTime")).toMillis()));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return myFiles;
    }
}
