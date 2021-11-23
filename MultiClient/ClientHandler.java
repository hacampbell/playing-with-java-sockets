package MultiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClientHandler extends Thread {
    private Socket client;
    private int id = new Random().nextInt(1000);
    private PrintWriter writer;
    private BufferedReader reader;

    public ClientHandler (Socket client) throws IOException {
        this.client = client;
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        writer = new PrintWriter(client.getOutputStream(), true);
    }

    public int GetId () {
        return id;
    }

    public void run () {
        try {
            writer.printf("Welcome Client %d!\n", id);

            while(true) {
                String message = reader.readLine();

                if(message.equals("quit")) {
                    client.close();
                    System.out.printf("Client %d disconnected\n", id);
                    break;
                }

                writer.println(message);
            }
        } catch (Exception e) {
            System.out.printf("Error from clientHandler of client %d\n", id);
            e.printStackTrace();
        }
    }
}
