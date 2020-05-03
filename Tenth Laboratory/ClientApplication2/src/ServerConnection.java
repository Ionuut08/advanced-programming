import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/* handling connections to the server and the input from the server
 *   else the other clients will still wait for somebody to type something on the keyboard
 *   We did not design the client to just receive messages from the server without getting
 *   blocked by reading the keyboard. We will have to implement a client own thread
 */


public class ServerConnection implements Runnable{
    private Socket serverConnectionSocket;
    private BufferedReader in;

    public  ServerConnection(Socket socket) throws IOException {
        serverConnectionSocket = socket;
        in = new BufferedReader(new InputStreamReader(serverConnectionSocket.getInputStream()));
    }

    @Override
    public void run() {
            try {
                while (true) {
                    String serverResponse = in.readLine();

                    if (serverResponse == null) {
                        break;
                    } else {
                        System.out.println("Server says: " + serverResponse);
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
