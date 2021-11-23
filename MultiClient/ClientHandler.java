package MultiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ClientHandler extends Thread {
    private Socket client;
    private int id = new Random().nextInt(1000);
    private PrintWriter writer;
    private BufferedReader reader;
    private ArrayList<ClientHandler> clients;

    public ClientHandler (Socket client, ArrayList<ClientHandler> clients) throws IOException {
        this.client = client;
        this.clients = clients;
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        writer = new PrintWriter(client.getOutputStream(), true);
    }

    public int GetId () {
        return id;
    }

    public void MessageAll (String message) {
        for (ClientHandler c : clients) {
            c.writer.printf("%d: %s\n", id, message);
        }
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

                //writer.println(message);
                MessageAll(message);
            }
        } catch (Exception e) {
            System.out.printf("Error from clientHandler of client %d\n", id);
            e.printStackTrace();
        }
    }
}
