import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private PrintStream printStream;
    private Player player;
    private BufferedReader bufferedReader;
    private Board board;
    private String playerMark;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        playerMark = "Player1Mark";
        player = new Player(printStream, bufferedReader, "1", playerMark, board);
    }

    @Test
    public void shouldPromptPlayerForInputWhenTheyMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");
        player.move();

        verify(printStream).println("Player #1, enter a number from 1 to 9:");
    }

    @Test
    public void shouldMarkTheBoardInCellOneWhenUserEntersTheNumber1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        player.move();

        verify(board).placeMark(1, playerMark);
    }

    @Test
    public void shouldInformPlayerWhenCellIsAlreadyTaken() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isCellTaken(anyInt()))
                .thenReturn(true)
                .thenReturn(false);

        player.move();

        verify(printStream).println("Location already taken.");
    }

    @Test
    public void shouldKeepAskingForUserInputWhenTheFirstCellChosenIsTaken() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isCellTaken(anyInt()))
                .thenReturn(true)
                .thenReturn(false);

        player.move();

        verify(bufferedReader, times(2)).readLine();
    }

    @Test
    public void shouldKeepAskingForUserInputWhenTheFirstTwoCellsChosenAreTaken() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isCellTaken(anyInt()))
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);

        player.move();

        verify(bufferedReader, times(3)).readLine();
    }
}