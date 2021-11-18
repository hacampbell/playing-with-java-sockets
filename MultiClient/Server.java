/**
 * A multi-client chat server using sockets and threads
 * @author Henry Campbell
 */

package MultiClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 53044;
    public static final int MAXCLIENTS = 5;
    public static void main (String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        try {
            while(true) {
                Socket client = server.accept();
                ClientHandler ch = new ClientHandler(client);
                ch.start();
                System.out.println("Client connected!");
            }
        } finally {
            server.close();
        }
    }
}
