import java.io.PrintStream;
import java.util.Collection;
import java.util.List;

import static java.lang.String.format;

public class Board {
    private Collection<WinCondition> winConditions;
    private PrintStream printStream;
    private List<String> cells;

    public Board(Collection<WinCondition> winConditions, PrintStream printStream, List<String> cells) {
        this.winConditions = winConditions;
        this.printStream = printStream;
        this.cells = cells;
    }

    public void print() {
        String board =
                " %s | %s | %s \n" +
                "-----------\n" +
                " %s | %s | %s \n" +
                "-----------\n" +
                " %s | %s | %s \n";
        printStream.println(format(board, cells.toArray()));
    }

    public void placeMark(int cellNumber, String mark) {
        setCell(cellNumber, mark);
    }

    public boolean isCellTaken(int chosenCell) {
        boolean cellIsEmpty = getCell(chosenCell).equals(" ");
        return !cellIsEmpty;
    }

    private String getCell(int cellNumber) {
        return cells.get(cellNumber-1);
    }

    private String setCell(int cellNumber, String mark) {
        return cells.set(cellNumber - 1, mark);
    }

    public boolean isFull() {
        for (int i = 0; i < cells.size(); i++){
            if (cells.get(i) == " "){
                return false;
            }
        }

        return true;
    }

    public boolean isWon() {
        for (WinCondition winCondition : winConditions) {
            if (winCondition.isTrue(cells)){
                return true;
            }
        }
        return false;
    }


}
