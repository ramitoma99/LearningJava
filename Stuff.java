import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Stuff {
    public static void main (String[] args) throws FileNotFoundException {
        Business iceShop = new Business("IceLels", 12345);
        iceShop.getBusiName();
        iceShop.getBusiNumber();

        FileCreator saveBusi = new FileCreator();
        saveBusi.createFile("lel.txt", 32434, "this is the first text in the function");

        FileReader readFile = new FileReader();
        readFile.readFile("lel.txt");
    }
}

class Business {
    String name;
    int number;
    Business(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void getBusiName(){
        System.out.println("This busi name is: " + this.name);
    }

    public void getBusiNumber() {
        System.out.println("This busi number is: " + this.number);
    }
}

class FileCreator {
    public void createFile (String fileName, int busiNumber, String fileText){
        try {
            FileWriter makeFile = new FileWriter(fileName);
            makeFile.write("this is the number of the busi: " + busiNumber + "\n");
            makeFile.write("this is the text: " + fileText + "\n");
            makeFile.close();
        } catch (IOException e){
            System.out.println("An error while writing file has happend.");
        }
    }
}

class FileReader {
    public void readFile(String fileName) throws FileNotFoundException {
        File readFile = new File(fileName);
        Scanner fileReader = new Scanner(readFile);
        while (fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            System.out.println("The file contains: " + line);
        }

    }
}
