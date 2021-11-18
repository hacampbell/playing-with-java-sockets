package MultiClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClientHandler extends Thread {
    private Socket client;
    private int id;

    public ClientHandler (Socket client) {
        this.client = client;
        Random rnd = new Random();
        this.id = rnd.nextInt(10000);
    }

    public int GetId () {
        return id;
    }

    public void run () {
        try {
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            for (int i = 0; i < 50; i++) {
                writer.println("Welcome, Client " + id);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
