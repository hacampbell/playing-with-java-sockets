/**
 * A multi-client chat server using sockets and threads
 * @author Henry Campbell
 */

package MultiClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 53044;
    private static ArrayList<ClientHandler> connectedClients = new ArrayList<ClientHandler>();

    public static void main (String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);           // Create our server

        System.out.println("Listening on port: " + PORT);

        try {
            while(true) {
                Socket client = server.accept();                                    // Accept new connections
                ClientHandler ch = new ClientHandler(client, connectedClients);     // Create a handler for the connection
                ch.start();                                                         // Start the thread for the handler
                connectedClients.add(ch);                                           // Add the client to our list of connections
                System.out.println("Client connected!");                            // Do some logging
            }
        } finally {
            server.close();
        }
    }
}
