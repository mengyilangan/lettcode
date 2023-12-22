package every149;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1499Test {

    @Test
    void findMaxValueOfEquation() {
        Solution1499 solution = new Solution1499();
        int[][] points = {{-17, 13}, {2, 1}, {8, -5}, {18, -20}};
        int k = 26;
        int value = solution.findMaxValueOfEquation(points, k);
        System.out.println(value);
    }
}