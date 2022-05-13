package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.Scanner;

public class txt {
    public static void CreateFile() {
        try {
            File file = new File("Check.txt");
            if (file.createNewFile()) {
                System.out.println("File was successfully created - " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void TextFileReading() {
        try {
            File file = new File("Check.txt");
            if (file.isFile()) {
                FileReader reader = new FileReader("Check.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String userLine;
                System.out.println("File's content: \n");
                while ((userLine = bufferedReader.readLine()) != null) {
                    System.out.println(userLine);
                }
                reader.close();
            }
            else {
                System.out.println("File doesn't exist");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TextFileWriting() {
        try {
            FileWriter writer = new FileWriter("Check.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your string: ");
            String enter = in.nextLine();
            bufferedWriter.write(enter + "\r\n");
            bufferedWriter.close();
            System.out.println("Done. You can check it now");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DeleteFile() {
        File eraser = new File("Check.txt");
        if (eraser.delete()) {
            System.out.println("File was successfully deleted");
        } else {
            System.out.println("File hasn't been found");
        }
    }
}
