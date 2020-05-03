import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientThread implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private List<ClientThread> clients;

    public ClientThread(Socket clientSocket, ArrayList<ClientThread> clients) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();
                if (request.contains("name")) {
                    out.println(GameServer.getRandomName());
                } else if (request.startsWith("say")) {
                    int firstSpace = request.indexOf(" ");
                    if (firstSpace != -1) {
                        outToAll(request.substring(firstSpace+1));
                    }
                } else if (request.startsWith("stop")) {
                    client.close();
                    System.out.println("Closed");
                    break;
                }
                else {
                    out.println("Type <<tell me a name>> to get a random name");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            out.close();
            System.out.println("Closed");
            try {
                in.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void outToAll(String message) {
        for (ClientThread aClient : clients) {
            aClient.out.println(message);
        }
    }
}


