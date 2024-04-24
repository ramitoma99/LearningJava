import com.rami.filemanager.FileUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Stuff{

    public static void main (String[] args) throws IOException {

        Scanner choiceScanner = new Scanner(System.in);


        ArrayList<String> utils = new ArrayList<>();
        utils.add("File Manager - create, write, read, delete files (type fm for this)");

        System.out.println("Hello, please choose a utility: ");
        for (String option : utils) {
            System.out.println(option);
        }

        String utilChoice = choiceScanner.nextLine().toLowerCase();

        switch (utilChoice) {
            case "fm":
                System.out.println("Welcome to file Manager! You have these options: m, w, r, d");
                String optionChoice = choiceScanner.nextLine().toLowerCase();
                FileUtils fileManager = new FileUtils();
                switch (optionChoice) {
                    case "m":
                        fileManager.createFile();
                        break;
                    case "w":
                        fileManager.writeToFile();
                        break;
                    case "r":
                        fileManager.readFile();
                        break;
                    case "d":
                        fileManager.deleteFile();
                        break;
                    default:
                        System.out.println("Invalid input! :(");
                }
        }
    }
}
