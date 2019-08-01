package program;

import entities.MyFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.*;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path to analyse: ");
        String path = sc.nextLine();

        System.out.print("Enter file full path to save log: ");
        String savePath = sc.nextLine();

        try (Stream<Path> walk = Files.walk(Paths.get(path))){

            List<String> files = walk.map(x -> x.toString()).collect(Collectors.toList());

            for (String file : files) {

                File newFile = new File (file);
                MyFile myFile = new MyFile(newFile.getName(), newFile.getParent(), Files.size(newFile.toPath()), Files.getAttribute(newFile.toPath(), "basic:creationTime"));

                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(savePath), CREATE, APPEND, WRITE)) {

                    writer.write(myFile.toString());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}