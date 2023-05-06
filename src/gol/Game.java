package gol;

public class Game {

    private int rows;
    private int columns;
    private boolean [][] board;

    public Game() {
        this.rows = 15;
        this.columns = 20;
        this.board = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.board[i][j] = false;
            }
        }
    }

    public void markAlive(int x, int y) {
        board[y][x] = true;
    }

    public boolean isAlive(int x, int y) {
        return board[y][x];
    }

    public void toggle(int x, int y) {
        board[y][x] = !this.isAlive(x, y);
    }

    public Integer getNeighbourCount(int x, int y) {
        // was inspired by this: https://www.geeksforgeeks.org/find-safe-cells-in-a-matrix/
        int counter = 0;

        counter += checkCell(y - 1, x - 1, board);
        counter += checkCell(y - 1, x, board);
        counter += checkCell(y - 1, x + 1, board);
        counter += checkCell(y, x + 1, board);
        counter += checkCell(y + 1, x + 1, board);
        counter += checkCell(y + 1, x, board);
        counter += checkCell(y + 1, x - 1, board);
        counter += checkCell(y, x - 1, board);

        return counter;
    }

    public int checkCell(int y, int x, boolean[][] matrix) { // return 0 or 1
        if (y < 0 || x < 0 || y > this.rows || x > this.columns) {
            return 0;   // if a cell is out of matrix
        } else if (!matrix[y][x]) {
            return 0;   // if a cell is in matrix
        }
        return 1;
    }

    public void nextFrame() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                int neighborCount = getNeighbourCount(x, y);
                boolean isLiving = isAlive(x, y);
                board[y][x] = nextState(isLiving, neighborCount);
            }
        }
    }

    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.board[i][j] = false;
            }
        }
    }

    public boolean nextState(boolean isLiving, int neighborCount) {
        if (neighborCount < 2 || neighborCount > 3) {
            return false;
        } else if (neighborCount == 2) {
            return isLiving;
        } else {
            return true;
        }
    }
}
