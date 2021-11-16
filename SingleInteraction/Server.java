package SingleInteraction;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 53044; 

    public static void main (String[] args) throws IOException {
        // Create the server socket we listen for connections on
        ServerSocket serverSocket = new ServerSocket(PORT);
        PrintLog("Server listening on port" + PORT);

        // Accept a client connection when we get one
        Socket client = serverSocket.accept();
        PrintLog("Client Connected...");

        // Create a PritnWriter that allows us to send data to the client
        PrintWriter writer = new PrintWriter(client.getOutputStream());

        // Write some simple data
        writer.println("Hello World!");
        PrintLog("Sending data (\"Hello World\")");


        // Close the server and client sockets
        PrintLog("Closing sockets");
        client.close();
        serverSocket.close();
    }


    /**
     * A very simple logger to allow for easier output to the console.
     * @param msg The message to display to the console
     */
    private static void PrintLog (String msg) {
        System.out.println("[LOG] " + msg);
    }
}
