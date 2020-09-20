import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution31Test {
    Solution31 solution31 = new Solution31();

    @Test
    void nextPermutation() {
        int[] a = new int[]{ 1, 3, 2 };
        solution31.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
