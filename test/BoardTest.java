import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> cells;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        cells = new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        board = new Board(printStream, cells);
    }

    @Test
    public void shouldPrintAnEmptyBoardWhenPrinted() {
        board.print();

        verify(printStream).println(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }

    @Test
    public void shouldPlaceXInFirstCellWhenXIsMarkedInThatLocation() {
        board.placeMark(1, "X");

        assertThat(cells.get(0), is("X"));
    }

    @Test
    public void shouldPlaceStarInFirstCellWhenXIsMarkedInThatLocation() {
        board.placeMark(1, "*");

        assertThat(cells.get(0), is("*"));
    }

    @Test
    public void shouldPlaceXInSecondCellWhenMoveIs2() {
        board.placeMark(2, "X");

        assertThat(cells.get(1), is("X"));
    }

    @Test
    public void shouldPutMarksOnBoardForEachCell() {
        for (int cellIndex = 0; cellIndex < 9; cellIndex++) {
            cells.set(cellIndex, "X");
        }

        board.print();

        verify(printStream).println(
                " X | X | X \n" +
                        "-----------\n" +
                        " X | X | X \n" +
                        "-----------\n" +
                        " X | X | X \n"
        );
    }

    @Test
    public void shouldReportCellIsTakenWhenCellIsMarked() {
        cells.set(0, "*");

        assertThat(board.isCellTaken(1), is(true));
    }

    @Test
    public void shouldReportCellIsNotTakenWhenCellIsBlank() {
        cells.set(0, " ");

        assertThat(board.isCellTaken(1), is(false));
    }

    @Test
    public void shouldBeFullWhenAllTheCellsAreTaken() {
        cells.set(0, "*");
        cells.set(1, "*");
        cells.set(2, "*");
        cells.set(3, "*");
        cells.set(4, "*");
        cells.set(5, "*");
        cells.set(6, "*");
        cells.set(7, "*");
        cells.set(8, "*");

        assertTrue(board.isFull());
    }

    @Test
    public void shouldNotBeFullWhenOnlyEightOfTheCellsAreTaken() {
        cells.set(0, "*");
        cells.set(1, "*");
        cells.set(2, "*");
        cells.set(3, "*");
        cells.set(4, "*");
        cells.set(5, "*");
        cells.set(6, "*");
        cells.set(7, "*");

        assertFalse(board.isFull());
    }

}