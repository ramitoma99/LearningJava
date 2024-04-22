import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Stuff {
    public static void main (String[] args){
        Business iceShop = new Business("IceLels", 12345);
        iceShop.getBusiName();
        iceShop.getBusiNumber();
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
    public void createFile (){
        try {
            FileWriter makeFile = new FileWriter("busiName.txt");
        } catch (IOException e){
            System.out.println("An error while writing file has happend.");
        }
    }
}
