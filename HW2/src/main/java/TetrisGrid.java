//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
    public void clearRows() {
        int width = grid.length;
        int height = grid[0].length;

        int nextY = 0;
        for (int y = 0; y < height; y++) {
            boolean full = true;
            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {
                    full = false;
                    break;
                }
            }
            if (!full) {
                for (int x = 0; x < width; x++) {
                    grid[x][nextY] = grid[x][y];
                }
                nextY++;
            }
        }
        for (int y = nextY; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = false;
            }
        }
    }
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // YOUR CODE HERE
	}
}
