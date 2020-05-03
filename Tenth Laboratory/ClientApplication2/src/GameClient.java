import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9494;

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);

        ServerConnection serverConnection = new ServerConnection(clientSocket);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        new Thread(serverConnection).start();

        while (true) {
            System.out.println("> ");
            String command = keyboard.readLine();

            if (command.equals("exit")) break;
            out.println(command);
        }
    }
}
