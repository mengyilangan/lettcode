package every235;

public class Solution2352 {
    public int equalPairs(int[][] grid) {
        int count = 0;
        for (int row = 0; row <= grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                if (equals(grid, row, col)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private boolean equals(int[][] grid, int row, int col) {
        for (int k = 0; k < grid.length; k++) {
            if (grid[row][k] != grid[k][col]) {
                return false;
            }
        }
        return true;
    }
}
