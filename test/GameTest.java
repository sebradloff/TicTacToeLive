import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private Game game;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        onlyOnePlayerMoves();
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2, player1);
    }

    @Test
    public void shouldPrintBoardWhenStarted() {
        game.start();

        verify(board, atLeastOnce()).print();
    }

    @Test
    public void shouldTellPlayer1ToMove() {
        game.start();

        verify(player1).move();
    }

    @Test
    public void shouldPrintBoardTwoTimesWhenOnlyOnePlayerMoves() {
        game.start();

        verify(board, times(2)).print();
    }

    @Test
    public void shouldPrintBoardThreeTimesWhenEachPlayerMovesOne() {
        bothPlayersTakeOneMove();

        game.start();

        verify(board, times(3)).print();
    }

    @Test
    public void shouldAlternatePlayers() {
        bothPlayersTakeOneMove();

        game.start();

        verify(player2).move();
    }

    @Test
    public void shouldNotPlayWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(player1, never()).move();
        verify(player2, never()).move();
    }

    @Test
    public void shouldPlayUntilTheBoardIsFull() {
        game.start();

        verify(player1).move();
        verify(player2, never()).move();
    }

    private void onlyOnePlayerMoves() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
    }

    private void bothPlayersTakeOneMove() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
    }
}