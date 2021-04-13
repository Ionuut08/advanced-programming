import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {

    private String name;
    private Board board;
    private boolean controlPlayer = true;
    private int counter = 20;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }


    /*
     * Each player will get a random token from the list and it will be stored in each player's list. Then, the token will
     * be removed from the list of tokens which Board generates.
     *
     * The extracted tokens will be sorted, in order to check the arithmetic progression.
     * */

    public synchronized void run() {
        try {
            while (controlPlayer) {
                Random randomToken = new Random();
                Token extractedToken = board.getTokens().get(randomToken.nextInt(counter));

                board.getTokens().remove(extractedToken);
                counter--;
                if (board.getTokens().size() > 0) {
                    System.out.println(this.name + " extracted the token " + extractedToken.getToken());
//                    Arrays.sort(board.getTokens().toArray());

                } else {
                    System.out.println("The board is empty." + this.name + " won the game!");
                    controlPlayer = true;
                }
            }
        } catch (Exception exception) {
            System.out.println("Nope, player");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", board=" + board +
                '}';
    }
}