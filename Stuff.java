import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Stuff{
    public static void main (String[] args) throws IOException {
        FileUtils saveFile = new FileUtils();
        saveFile.createFile("HelloNewFile.txt");
    }
}
class FileUtils {
    public void createFile(String fileName) throws IOException {
        File createFileObj = new File(fileName);
        createFileObj.createNewFile();
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

        if (userDelConfInput.equals("y")) {
            deleteFileObj.delete();
            System.out.println("File " + fileName + " deleted successfully!");
        } else {
            System.out.println("File remains. :D");
        }

    }
}