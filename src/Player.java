import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class Player {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private String name;
    private String symbol;
    private Board board;

    public Player(PrintStream printStream, BufferedReader bufferedReader, String name, String symbol, Board board) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.name = name;
        this.symbol = symbol;
        this.board = board;
    }

    public void move() {
        printStream.println("Player #" + name +", enter a number from 1 to 9:");
        int chosenCell = parseInt(readLine());
        while (board.isCellTaken(chosenCell)){
            printStream.println("Location already taken.");
            chosenCell = parseInt(readLine());
        }
        board.placeMark(chosenCell, symbol);
    }

    private String readLine() {
        String string = null;
        try {
            string = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }
}
