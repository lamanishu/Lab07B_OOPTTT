
public class Board {
    private String[][] tiles;

    public Board() {
        tiles = new String[3][3];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j] = "";
            }
        }
    }

    public boolean setTile(int row, int col, String symbol) {
        if (tiles[row][col].equals("")) {
            tiles[row][col] = symbol;
            return true;
        }
        return false;
    }

    public String getTile(int row, int col) {
        return tiles[row][col];
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tiles[i][j].equals("")) return false;
        return true;
    }

    public String checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (!tiles[i][0].equals("") &&
                    tiles[i][0].equals(tiles[i][1]) &&
                    tiles[i][1].equals(tiles[i][2]))
                return tiles[i][0];

            if (!tiles[0][i].equals("") &&
                    tiles[0][i].equals(tiles[1][i]) &&
                    tiles[1][i].equals(tiles[2][i]))
                return tiles[0][i];
        }

        if (!tiles[0][0].equals("") &&
                tiles[0][0].equals(tiles[1][1]) &&
                tiles[1][1].equals(tiles[2][2]))
            return tiles[0][0];

        if (!tiles[0][2].equals("") &&
                tiles[0][2].equals(tiles[1][1]) &&
                tiles[1][1].equals(tiles[2][0]))
            return tiles[0][2];

        return null;
    }
}