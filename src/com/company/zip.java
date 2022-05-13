package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class zip {
    public static void CreateFileAndZip() throws IOException {
        String source = "Test.txt";
        File file = new File(source);
        file.createNewFile();

        FileWriter writer = new FileWriter("Test.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter something into file: ");
        String enter = in.nextLine();
        bufferedWriter.write(enter + "\r\n");
        bufferedWriter.close();

        FileOutputStream fos = new FileOutputStream("Test.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        FileInputStream fis = new FileInputStream(file);
        ZipEntry ze = new ZipEntry(file.getName());
        zos.putNextEntry(ze);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }
        System.out.println("File and ZIP are created");
        zos.close();
        fis.close();
        fos.close();
    }

    public static File newFile(File destDir, ZipEntry ze) throws IOException {
        File destFile = new File(destDir, ze.getName());

        String destDirPath = destDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + ze.getName());
        }
        return destFile;
    }

    public static void unZip() throws IOException {
        String sourceZip = "Test.zip";
        File destDir = new File("src/unzipped");
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(sourceZip));
        ZipEntry ze = zis.getNextEntry();
        while (ze != null) {
            File newFile = newFile(destDir, ze);
            if (ze.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            ze = zis.getNextEntry();
        }
        System.out.println("Archive was unzipped");
        zis.closeEntry();
        zis.close();
    }

    public static void deleteZipAndFile() throws IOException {
        File eraser_zip = new File("Test.zip");
        File eraser_file = new File("Test.txt");
        if ((eraser_file.delete()) & (eraser_zip.delete())) {
            System.out.println("Source file and ZIP were deleted");
        }
        else {
            System.out.println("Files haven't been found");
        }
    }
}
