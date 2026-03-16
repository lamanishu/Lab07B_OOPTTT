import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TTTFrame extends JFrame {
    private TTTTileButton[][] buttons;
    private Game game;

    public TTTFrame(Game game) {
        this.game = game;
        buttons = new TTTTileButton[3][3];

        this.setTitle("Tic Tac Toe");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new TTTTileButton(i, j);
                this.add(buttons[i][j]);

                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TTTTileButton btn = (TTTTileButton)e.getSource();
                        game.playTurn(btn.getRow(), btn.getCol());
                    }
                });
            }
        }

        this.setVisible(true);
    }

    public void updateButton(int row, int col, String symbol) {
        buttons[row][col].setText(symbol);
    }

    public void showWinner(String symbol) {
        JOptionPane.showMessageDialog(this, symbol + " wins!");
        game.resetGame();
    }

    public void showDraw() {
        JOptionPane.showMessageDialog(this, "Draw!");
        game.resetGame();
    }

    public void resetButtons() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setText("");
    }
}
