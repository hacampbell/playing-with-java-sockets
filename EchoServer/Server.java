package EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** 
 *  A simple, single client, echo server. This was made purely as a way for me
 *  to get a basic introduction to sockets in java, as well as to act as a 
 *  jumping off point for future work.
 * 
 *  @author     Henry Campbell
 */

public class Server {
    private static final int PORT = 53044; 
    
    public static void main (String[] args) throws IOException {
        // Create the server socket we listen for connections on
        ServerSocket serverSocket = new ServerSocket(PORT);
        PrintLog("Server listening on port " + PORT);

        try {
            // Accept a client connection when we get one
            Socket client = serverSocket.accept();
            PrintLog("Client Connected...");

            // Create a PritnWriter that allows us to send data to the client
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            // Create BufferedReader to get input from the client
            BufferedReader clientMessage = new BufferedReader(new InputStreamReader(client.getInputStream()));

            writer.println("Welcome, Client");
            
            while (true) {  // Loop so we can keep taking connections
                String message = clientMessage.readLine();

                // If we receive a message that's null, it means the client has disconnected.
                if (message != null) {
                    PrintLog("Client said: " + message);
                    writer.println(message);
                } else {
                    client.close();
                    break;
                }
            }
        } finally {
            // Make sure we close our resources.
            PrintLog("Closing Server Socket");
            serverSocket.close();
        }
    }


    /**
     * A very simple logger to allow for easier output to the console.
     * @param msg The message to display to the console
     */
    private static void PrintLog (String msg) {
        System.out.println("[LOG] " + msg);
    }
}
