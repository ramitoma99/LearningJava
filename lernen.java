public class lernen {
    public static void main (String[] args){
        Smartphone iPhone13 = new Smartphone();

        iPhone13.klingeln();
        iPhone13.color = "pink";
        iPhone13.modelNumber = 32432;

        System.out.println("the color pf the ophonme is: " + iPhone13.color);
        System.out.println(iPhone13.modelNumber);

        iPhone13.takePic();

        iPhones iPhone10 = new iPhones();
        iPhone10.praiseApple();


    }
}

class Smartphone {
    String color;
    int modelNumber;

    public void klingeln(){
        System.out.println("Das Smartphone klingelt! ring ringiriungirnginrgnrgnrgni!!");
    }

    public void takePic(){
        System.out.println("ur phone has taken a pic lol! :D");
    }
}

class iPhones extends Smartphone{
    public void praiseApple(){
        System.out.println("OMG i love apple!!!!!!!");
    }
}
