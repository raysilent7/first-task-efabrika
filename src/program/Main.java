package program;

import entities.MyFile;
import util.FileReporter;
import util.FileScanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
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
        FileScanner fs = new FileScanner();
        FileReporter fr = new FileReporter();

        System.out.print("Enter file full path to analyse: ");
        Path path = Paths.get(sc.nextLine());

        System.out.print("Enter file full path to save log: ");
        Path savePath = Paths.get(sc.nextLine());

        fs.fileCollector(path);
        fr.fileReporter(savePath, fs.getMyFiles());

        sc.close();
    }
}