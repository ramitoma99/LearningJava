import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Stuff{

    public static void main (String[] args) throws IOException {
        String fileName = "HelloNewFile.txt";
        FileUtils fileManager = new FileUtils();

        ArrayList<String> options = new ArrayList<>();
        options.add("m - make file");
        options.add("w - write line to file");
        options.add("r - read lines from file");
        options.add("d - delete file");

        System.out.println("Welcome, choose your option from FileMananger :)");
        for (String option : options) {
            System.out.println(option);
        }

        Scanner getUserOption = new Scanner(System.in);
        String selectedOption = getUserOption.nextLine().toLowerCase();

        switch (selectedOption) {
            case "m":
                fileManager.createFile(fileName);
                break;
            case "w":
                System.out.println();
                String text = "";
                fileManager.writeToFile(fileName, "");
                break;
            case "r":
                fileManager.readFile(fileName);
                break;
            case "d":
                fileManager.deleteFile(fileName);
                break;
            default:
                System.out.println("Invalid choice!");
        }

    }
}
class FileUtils {
    public void createFile(String fileName) throws IOException {
        File createFileObj = new File(fileName);
        if (createFileObj.createNewFile()) {
            System.out.println("File " + fileName +" created successfully!");
        } else {
            System.out.println("File " + fileName + " already exists!");
        }
    }

    public void writeToFile(String fileName, String text) throws IOException {
        FileWriter writeToFileObj = new FileWriter(fileName);
        writeToFileObj.write(text);
        writeToFileObj.close();
        System.out.println("Successfully written: " + text + " to file: " + fileName);
    }

    public void readFile(String fileName) throws FileNotFoundException {
        File readFileObj = new File(fileName);
        Scanner fileToBeRead = new Scanner(readFileObj);

        while (fileToBeRead.hasNextLine()){
            String line = fileToBeRead.nextLine();
            System.out.println("The file: " + fileName + " contains the text: " + line);
        }
        fileToBeRead.close();
    }

    public void deleteFile(String fileName){

        File deleteFileObj = new File(fileName);
        Scanner userDeleteConfirm = new Scanner(System.in);
        System.out.println("Delete: " + fileName + "? (y/n)");
        String userDelConfInput = userDeleteConfirm.nextLine();

        if (userDelConfInput.equals("y") && deleteFileObj.exists()) {
            deleteFileObj.delete();
            System.out.println("File " + fileName + " deleted successfully!");
        } else {
            System.out.println("File deletion canceled.");
        }

    }
}