package SingleInteraction;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** 
 *  A simple, single client, single interaction socket server. This was made 
 *  purely as a way for me to get a basic introduction to sockets in java, as 
 *  well as to act as a jumping off point for future work.
 * 
 *  @author     Henry Campbell
 */

public class Server {
    private static final int PORT = 53044; 

    // We'll hide our resource leak warning for this little toybox project
    @SuppressWarnings({"resource"})
    public static void main (String[] args) throws IOException {
        // Create the server socket we listen for connections on
        ServerSocket serverSocket = new ServerSocket(PORT);
        PrintLog("Server listening on port" + PORT);

        while (true) {  // Loop so we can keep taking connections
            
            // Accept a client connection when we get one
            Socket client = serverSocket.accept();
            PrintLog("Client Connected...");

            // Create a PritnWriter that allows us to send data to the client
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            PrintLog("Sending data (\"Hello World\")");
            writer.println("Hello World!");     // Write some simple data
            client.close();
        }


        /* Close the server socket, but we'll comment this out because it isn't
           actually reachable due to the while loop */
        
        // PrintLog("Closing Server Socket");
        // serverSocket.close();
    }


    /**
     * A very simple logger to allow for easier output to the console.
     * @param msg The message to display to the console
     */
    private static void PrintLog (String msg) {
        System.out.println("[LOG] " + msg);
    }
}
