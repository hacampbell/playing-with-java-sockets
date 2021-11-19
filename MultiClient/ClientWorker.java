/**
 * A worker class designed to handle the networking for the client in a
 * multiple client chat app.
 */

package MultiClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientWorker extends Thread{
    private Socket conn;

    public ClientWorker (Socket conn) {
        this.conn = conn;
    }

    public void run () {
        try {
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println("Created buffered reader");
            while (true) {
                // Read input from the server and display it
                String response = serverInput.readLine();
                System.out.println(response);
                if (response == null) break;
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    
}
