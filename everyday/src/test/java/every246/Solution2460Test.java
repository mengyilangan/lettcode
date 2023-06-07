package every246;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution2460Test {
    @Test
    public void applyOperations() {
        Solution2460 solution = new Solution2460();
        int[] nums = {1, 2, 2, 1, 1, 0};
        int[] result = solution.applyOperations(nums);
        System.out.println(Arrays.toString(result));
    }
}