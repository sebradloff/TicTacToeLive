public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2, Player currentPlayer) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
    }

    public void start() {
        board.print();
        while (!board.isFull()){
            currentPlayer.move();
            swapPlayers();
            board.print();
        }
    }

    private void swapPlayers() {
        if (currentPlayer.equals(player1)){
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
