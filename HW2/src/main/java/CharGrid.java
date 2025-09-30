// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int r = grid.length;
        int c = grid[0].length;
        int minRow = r;
        int minCol = c;

        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == ch) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }
        if (maxRow < 0 || maxCol < 0) return 0;
        minRow--;
        minCol--;
        return (maxRow - minRow) * (maxCol - minCol);
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int count = 0;

        int r = grid.length;
        int c = grid[0].length;


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = grid[i][j];
                if (ch == ' ') continue;

                int up = branchLength(i, j, -1, 0, ch);
                int down = branchLength(i, j, 1, 0, ch);
                int left = branchLength(i, j, 0, -1, ch);
                int right = branchLength(i, j, 0, 1, ch);


                if (up > 1 && up == down && left == right && up == right) {
                    count++;
                }
            }
        }
        return count;
    }

    private int branchLength(int row, int col, int dr, int dc, char ch) {
        int len = 0;
        int r = row;
        int c = col;
        while (true) {
            r += dr;
            c += dc;
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) break;
            if (grid[r][c] != ch) break;
            len++;
        }
        return len;
    }

}
