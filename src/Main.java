import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> cells = new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        Board board = new Board(printStream, cells);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Player player1 = new Player(printStream, bufferedReader, "1", "X", board);
        Player player2 = new Player(printStream, bufferedReader, "2", "O", board);
        new Game(board, player1, player2, player1).start();
    }
}
