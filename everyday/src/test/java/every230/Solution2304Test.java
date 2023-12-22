package every230;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2304Test {

    @Test
    void minPathCost() {
        Solution2304 solution2304 = new Solution2304();
        int[][] grid = {
                {5, 3},
                {4, 0},
                {2, 1}
        };

        int[][] moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        int value = solution2304.minPathCost(grid, moveCost);
        System.out.println(value);
    }
}