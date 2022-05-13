package com.company;

import java.io.IOException;
import java.util.Scanner;

public class UserChoice {
    public static void txtJob() {
        boolean closeMenu = false;
        while (!closeMenu) {
            System.out.println("""
                                        
                    What do you wanna do with txt?
                    1. Create a new file
                    2. Write something into the file
                    3. File output
                    4. Delete the file
                    5. Back""");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt();
            switch (userInput) {
                case 1 -> txt.CreateFile();
                case 2 -> txt.TextFileWriting();
                case 3 -> txt.TextFileReading();
                case 4 -> txt.DeleteFile();
                case 5 -> {
                    System.out.println("...");
                    closeMenu = true;
                }
                default -> System.out.println("Incorrect number. Check your input");
            }
//            if (userInput == 1) {
//                CreateFile();
//            }
//            else if (userInput == 2) {
//                TextFileWriting();
//            }
//            else if (userInput == 3) {
//                TextFileReading();
//            }
//            else if (userInput == 4) {
//                DeleteFile();
//            }
//            else if (userInput == 5) {
//                System.out.println("Exiting...");
//                closeApp = true;
//            }
//            else {
//                System.out.println("Incorrect number. Check your input\n");
//            }
        }
    }

    public static void jsonJob() throws Exception {
        boolean close = false;
        objJSON object = new objJSON("Admin", 000001);
        while (!close) {
            System.out.println("""
                                        
                    What do you wanna do with json?
                    1. Write a new JSON file
                    2. Make an object, serialize it and write into a file
                    3. Read the file
                    4. Delete the file
                    5. Back""");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt();
            switch (userInput) {
                case 1 -> json.CreateJSON();
                case 2 -> json.toObjectJSON(object);
                case 3 -> json.readJSON("Users.json");
                case 4 -> json.deleteJSON();
                case 5 -> {
                    System.out.println("...");
                    close = true;
                }
                default -> System.out.println("Incorrect number. Check your input");
            }
        }
    }

    public static void xmlJob() throws Exception {
        boolean close = false;
        while (!close) {
            System.out.println("""
                                        
                    What do you wanna do with xml?
                    1. Create a new XML file
                    2. Write into the file
                    3. Read the file
                    4. Delete the file
                    5. Back""");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt();
            switch (userInput) {
                case 1 -> xml.createXML();
                case 2 -> xml.writeXML();
                case 3 -> xml.readXML();
                case 4 -> xml.deleteXML();
                case 5 -> {
                    System.out.println("...");
                    close = true;
                }
                default -> System.out.println("Incorrect number. Check your input");
            }
        }
    }

    public static void zipJob() throws IOException {
        boolean close = false;
        while (!close) {
            System.out.println("""
                                        
                    What do you wanna do with zip?
                    1. Create a new ZIP archive
                    2. Unzip the archive
                    3. Delete the archive and the file
                    4. Back""");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt();
            switch (userInput) {
                case 1 -> zip.CreateFileAndZip();
                case 2 -> zip.unZip();
                case 3 -> zip.deleteZipAndFile();
                case 4 -> {
                    System.out.println("...");
                    close = true;
                }
                default -> System.out.println("Incorrect number. Check your input");
            }
        }
    }
}

