package MultiClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClientHandler extends Thread {
    private Socket client;

    public ClientHandler (Socket client) {
        this.client = client;
    }

    public void run () {
        try {
            Random rnd = new Random();
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            int id = rnd.nextInt(1000);
            for (int i = 0; i < 50; i++) {
                writer.println("Welcome, Client " + id);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
