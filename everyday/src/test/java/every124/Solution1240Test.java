package every124;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1240Test {

    @Test
    void tilingRectangle() {
        Solution1240 solution = new Solution1240();
        int value = solution.tilingRectangle(2, 3);
        Assertions.assertEquals(3, value);
    }

    @Test
    void tilingRectangleCase2() {
        Solution1240 solution = new Solution1240();
        int value = solution.tilingRectangle(5, 8);
        Assertions.assertEquals(5, value);
    }

    @Test
    void tilingRectangleCase3() {
        Solution1240 solution = new Solution1240();
        int value = solution.tilingRectangle(11, 13);
        Assertions.assertEquals(6, value);
    }

    @Test
    void tilingRectangleCase4() {
        Solution1240 solution = new Solution1240();
        int value = solution.tilingRectangle(9, 4);
        Assertions.assertEquals(6, value);
    }

    @Test
    void tilingRectangleCase5() {
        Solution1240 solution = new Solution1240();
        int value = solution.tilingRectangle(9, 7);
        Assertions.assertEquals(6, value);
    }

    @Test
    void tilingRectangleCase6() {
        Solution1240 solution = new Solution1240();
        int value = solution.tilingRectangle(10, 9);
        Assertions.assertEquals(6, value);
    }
}