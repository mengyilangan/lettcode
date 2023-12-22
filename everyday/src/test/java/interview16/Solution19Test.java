package interview16;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution19Test {

    @Test
    void pondSizes() {
        Solution19 solution = new Solution19();
        int[][] lands = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] result = solution.pondSizes(lands);
        System.out.println(Arrays.toString(result));
    }
}