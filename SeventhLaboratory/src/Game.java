import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

/*
 * The game will have a title and a number of players. A list filled with tokens will be created,
 * the the board will be created, containing that list. There will be two Runnable objects containing each player.
 * The first player will start its own thread and randomly extract tokens from the list, after a waiting period of time,
 * the second player will start its thread, doing the same thing.
 * */

public class Game {

    private Thread thread;
    private final List<Player> players = new ArrayList<>();
    private volatile boolean running = false;
    private String title;
    private int numberOfPlayers;
    private Board board;

    public Game(String title, int numberOfPlayers) throws InterruptedException {
        this.title = title;
        this.numberOfPlayers = numberOfPlayers;

        List<Token> tokens = new ArrayList<>();
        for (int count = 1; count <= 20; count++) {
            tokens.add(new Token(count));
        }

        // #Check
//        System.out.println(tokens.toString());

        Board firstBoard = new Board(tokens);

        Runnable firstPlayer = new Player("Ionut", firstBoard);
        Runnable secondPlayer = new Player("Giovanni", firstBoard);
        players.add((Player) firstPlayer);
        players.add((Player) secondPlayer);

        // #Check
//        System.out.println(players.toString());

        try {
            synchronized (this) {
                while (firstBoard.getTokens().size() > 1) {
                    new Thread(firstPlayer).start();
                    new Thread(firstPlayer).run();
                    new Thread(firstPlayer).wait(100);
                    new Thread(secondPlayer).start();
                    new Thread(secondPlayer).run();
                    System.out.println("The game is on");
                }
            }

        } catch (Exception exception) {
            System.out.println("Nope, game");
        }

    }
}
