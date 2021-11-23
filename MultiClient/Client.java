package MultiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/** 
 *  A simple client for an echo server. This was made  purely as a way for me
 *  to get a basic introduction to sockets in java, as well as to act as a 
 *  jumping off point for future work.
 * 
 *  @author     Henry Campbell
 */

public class Client {
    private static final int PORT = 53044;
    private static final String ADDRESS = "127.0.0.1";
    
    public static void main (String[] args) throws IOException {
        // Create our socket to connect to the server with
        Socket connection = new Socket(ADDRESS, PORT);

        // Create a buffered read to get keyboard input form the user.
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

        // Create a print writer so we can send messages to the server
        PrintWriter writer = new PrintWriter(connection.getOutputStream(), true);

        // Run our connection handler thread
        ClientWorker cw = new ClientWorker(connection);
        cw.start();

        while (true) {
            // Read input from the client
            String message = clientInput.readLine();

            if (message.equals("quit")) {
                writer.println(message);
                break;
            }

            // Write our mesage to the server
            writer.println(message);
        }
        
        // Close our connection to the server before exiting
        connection.close();
    }
}