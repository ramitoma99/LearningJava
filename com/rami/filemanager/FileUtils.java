package com.rami.filemanager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {
    public void createFile() throws IOException {
        System.out.println("Welcome to File Manager's Create File!");
        System.out.print("Please enter file name to create it: ");
        Scanner enterFileName = new Scanner(System.in);
        String enteredFileName = enterFileName.nextLine();

        File createFileObj = new File(enteredFileName + ".txt");
        if (createFileObj.createNewFile()) {
            System.out.println("File " + enteredFileName +" created successfully!");
        } else {
            System.out.println("File " + enteredFileName + " already exists!");
        }
    }

    public void writeToFile() throws IOException {
        System.out.println("Welcome to File Manager's Write to File!");
        System.out.print("Please enter file name to write stuff in it: ");
        Scanner enterFileName = new Scanner(System.in);
        String enteredFileName = enterFileName.nextLine();

        System.out.print("Please enter text to write in the file: ");
        Scanner enterFileText = new Scanner(System.in);
        String enteredFileText = enterFileText.nextLine();

        FileWriter writeToFileObj = new FileWriter(enteredFileName + ".txt");
        writeToFileObj.write(enteredFileText);
        writeToFileObj.close();
        System.out.println("Successfully written: " + enteredFileText + " to file: " + enteredFileName);
    }

    public void readFile() throws FileNotFoundException {
        System.out.println("Welcome to File Manager's Read File!");
        System.out.print("Please enter the file name to read: ");
        Scanner enterFileName = new Scanner(System.in);
        String enteredFileName = enterFileName.nextLine();

        File readFileObj = new File(enteredFileName + ".txt");
        Scanner fileToBeRead = new Scanner(readFileObj);

        while (fileToBeRead.hasNextLine()) {
            String line = fileToBeRead.nextLine();
            System.out.println("The file: " + enteredFileName + " contains the text: " + line);
        }
        fileToBeRead.close();
    }

    public void deleteFile() {
        System.out.println("Welcome to File Manager's Delete File!");
        System.out.print("Please enter the file name to delete: ");
        Scanner enterFileName = new Scanner(System.in);
        String enteredFileName = enterFileName.nextLine();

        File deleteFileObj = new File(enteredFileName + ".txt");
        Scanner userDeleteConfirm = new Scanner(System.in);
        System.out.println("Delete: " + enteredFileName + "? (y/n)");
        String userDelConfInput = userDeleteConfirm.nextLine();

        if (userDelConfInput.equals("y") && deleteFileObj.exists()) {
            deleteFileObj.delete();
            System.out.println("File " + enteredFileName + " deleted successfully!");
        } else {
            System.out.println("File deletion canceled.");
        }
    }
}