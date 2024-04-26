import com.rami.serverclient.Server;

import java.io.IOException;

public class Server1 {
    public static void main(String[] args) throws IOException {
        Server server1 = new Server();
        server1.startServer();
    }
}
