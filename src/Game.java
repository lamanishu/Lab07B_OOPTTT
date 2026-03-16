
public class Game {
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Board board;
    private TTTFrame frame;

    public Game() {
        playerX = new Player("X");
        playerO = new Player("O");
        currentPlayer = playerX;
        board = new Board();
        frame = new TTTFrame(this);
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public void playTurn(int row, int col) {
        if (board.setTile(row, col, currentPlayer.getSymbol())) {
            frame.updateButton(row, col, currentPlayer.getSymbol());

            String winner = board.checkWinner();
            if (winner != null) {
                frame.showWinner(winner);
            } else if (board.isFull()) {
                frame.showDraw();
            } else {
                switchPlayer();
            }
        }
    }

    public void resetGame() {
        board.resetBoard();
        frame.resetButtons();
        currentPlayer = playerX;
    }
}