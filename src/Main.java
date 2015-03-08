import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> cells = new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));

        Board board = new Board(winConditions(), printStream, cells);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Player player1 = new Player(printStream, bufferedReader, "1", "X", board);
        Player player2 = new Player(printStream, bufferedReader, "2", "O", board);
        new Game(printStream, board, player1, player2, player1).start();
    }

    private static Collection<WinCondition> winConditions() {
        Collection<WinCondition> winConditions = new ArrayList<WinCondition>();
        winConditions.add(new WinCondition(0,1,2));
        winConditions.add(new WinCondition(3,4,5));
        winConditions.add(new WinCondition(6,7,8));
        winConditions.add(new WinCondition(0,3,6));
        winConditions.add(new WinCondition(1,4,7));
        winConditions.add(new WinCondition(2,5,8));
        winConditions.add(new WinCondition(0,4,8));
        winConditions.add(new WinCondition(2,4,6));
        return winConditions;
    }
}
