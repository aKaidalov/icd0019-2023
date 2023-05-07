package gol;

public class Game {
    /* There was a problem for me, which I didn't manage to understand.
    * Why when we crate a Gui object we pass values as number of columns, number of rows and ect,
    * but in my program rows and columns have opposite spots?
    * Doesn't it mean when I create rows, they are the same as coordinate Y and columns are coordinate X?
    */
    private int rows = 20;
    private int columns = 15;
    private boolean [][] board = new boolean[rows][columns];

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
        try {
            if (y < 0 || x < 0 || y > this.rows || x > this.columns) {
                return 0;   // if a cell is out of matrix
            } else if (!matrix[y][x]) {
                return 0;   // if a cell is in matrix, but its value is false
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public void nextFrame() {
        boolean[][] copy = new boolean[rows][columns];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                copy[y][x] = board[y][x];
            }
        }
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                int neighborCount = getNeighbourCount(x, y);
                boolean isLiving = isAlive(x, y);
                copy[y][x] = nextState(isLiving, neighborCount);
            }
        }

        board = copy;
    }

    public void clear() {
        board = new boolean[rows][columns];
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
