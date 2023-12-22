package every109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1094Test {
    private Solution1094 solution = new Solution1094();

    @Test
    void carPooling() {
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        int capacity = 3;
        solution.carPooling(trips, capacity);
    }

    /**
     * [[7,5,6],[6,7,8],[10,1,6]]
     * 16
     */
    @Test
    void carPoolingV1() {
        int[][] trips = {{10, 5, 7}, {10, 3, 4}, {7, 1, 8}, {6, 3, 4}};
        int capacity = 3;
        solution.carPooling(trips, capacity);
    }
}