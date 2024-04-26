import com.rami.filemanager.thingToStartFileUtils;
import java.io.IOException;
import com.rami.serverclient.*;

public class Stuff{

    public static void main (String[] args) throws IOException {

        //thingToStartFileUtils startUtils = new thingToStartFileUtils();
        //startUtils.startMe();

        Server server1 = new Server();
        server1.startServer();

    }
}
