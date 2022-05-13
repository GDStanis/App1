package com.igustudio.tmanager.utils;

import com.company.UserChoice;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Дисковые инструменты
**/

public class FileJob {

    private static DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");

    /**
     * Получить информацию об использовании диска
     **/
    public static List<Map<String, String>> getInfo() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        File [] roots = File.listRoots (); // Получить список разделов диска
        for (File file : roots) {
            Map<String, String> map = new HashMap<String, String>();

            long freeSpace=file.getFreeSpace();
            long totalSpace=file.getTotalSpace();
            long usableSpace=totalSpace-freeSpace;

            map.put("path", file.getPath());
            map.put ("freeSpace", freeSpace / 1024/1024/1024 + " Gb"); // Свободное пространство
            map.put ("usableSpace", usableSpace / 1024/1024/1024 + " Gb"); // Доступное пространство
            map.put ("totalSpace", totalSpace / 1024/1024/1024 + " Gb"); // общее пространство
            map.put ("usedSpace", DECIMALFORMAT.format (((double) usableSpace / (double) totalSpace) * 100) + "%"); // общее пространство

            list.add(map);
        }

        return list;
    }

    public static void PrintInfo() {
        File[] roots = File.listRoots();
        FileSystemView fsv = FileSystemView.getFileSystemView();

        for (File root : roots) {
            try {

                BasicFileAttributeView basicFileAttributeView =
                        Files.getFileAttributeView(root.toPath(), BasicFileAttributeView.class);

                BasicFileAttributes attributes = basicFileAttributeView.readAttributes();

                System.out.println("File Key: " + attributes.fileKey());
                System.out.println("Is Regular File: " + attributes.isRegularFile());
                System.out.println("Is Other: " + attributes.isOther());
                System.out.println("Is SymbolicLink: " + attributes.isSymbolicLink());
                System.out.println("Is Directory: " + attributes.isDirectory());

                System.out.println("Drive Name: " + root);
                System.out.println("Description: " + fsv.getSystemTypeDescription(root));
                System.out.println("Is Drive: " + fsv.isDrive(root));
                System.out.println("Is File System: " + fsv.isFileSystem(root));
                System.out.println("Is File System Root: " + fsv.isFileSystemRoot(root));
                System.out.println("Is Floppy Drive: " + fsv.isFloppyDrive(root));
                System.out.println("Is Hidden File: " + fsv.isHiddenFile(root));
                System.out.println("Is Traversable: " + fsv.isTraversable(root));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public static void main(String[] args) throws Exception {
        System.out.println(getInfo());
        PrintInfo();
        Scanner in = new Scanner(System.in);
        boolean closeApp = false;
        while (!closeApp) {

            System.out.println("""
                    
                    Which one do you wanna work with?
                    1. TXT
                    2. JSON
                    3. XML
                    4. ZIP
                    5. Exit""");
            int userInput = in.nextInt();
            switch (userInput) {
                case 1 -> UserChoice.txtJob();
                case 2 -> UserChoice.jsonJob();
                case 3 -> UserChoice.xmlJob();
                case 4 -> UserChoice.zipJob();
                case 5 -> {
                    System.out.println("Exiting...");
                    closeApp = true;
                }
                default -> System.out.println("Incorrect number. Check your input");
            }
        }
    }
}