package SingleInteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/** 
 *  A simple single interaction client socket. This was made purely as a way
 *  for me to get a basic introduction to sockets in java, as well as to act as
 *  a jumping off point for future work.
 * 
 *  @author     Henry Campbell
 */

public class Client {
    private static final int PORT = 53044;
    private static final String ADDRESS = "127.0.0.1";
    
    public static void main (String[] args) throws IOException {
        // create our socket to connect to the server with
        Socket connection = new Socket(ADDRESS, PORT);

        // Create buffered reader to be able to read the data we receive
        // A buffered reader takes an input stream reader, which in turn takes
        // an input stream.
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // Read server response
        String response = input.readLine();
        System.out.println(response);

        // Close our connection to the server before exiting
        connection.close();
    }
}
