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
        if (this.isAlive(x, y)) {
            board[x][y] = false;
        } else {
            board[x][y] = true;
        }
    }

    public Integer getNeighbourCount(int x, int y) {
        throw new RuntimeException("not implemented yet");
    }

    public void nextFrame() {
        throw new RuntimeException("not implemented yet");
    }

    public void clear() {
        throw new RuntimeException("not implemented yet");
    }

    public boolean nextState(boolean isLiving, int neighborCount) {
        throw new RuntimeException("not implemented yet");
    }
}
