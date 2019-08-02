package program;

import entities.MyFile;
import util.FileReporter;
import util.FileScanner;

import java.nio.file.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {

//        FileScanner fs = new FileScanner();
//        FileReporter fr = new FileReporter();

            System.out.print("Enter file full path to analyse: ");
            Path path = Paths.get(sc.nextLine());

            System.out.print("Enter file full path to save log: ");
            Path savePath = Paths.get(sc.nextLine());

            List<MyFile> l = FileScanner.doScan(path);
            FileReporter.generateLog(savePath, l);
        }
    }
}