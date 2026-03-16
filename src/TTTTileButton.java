import javax.swing.JButton;

public class TTTTileButton extends JButton {
    private int row;
    private int col;

    public TTTTileButton(int row, int col) {
        this.row = row;
        this.col = col;
        this.setText(""); // empty at start
        this.setFont(this.getFont().deriveFont(40f));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}