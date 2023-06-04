package every246;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2456Test {

    @Test
    void distinctAverages() {
        Solution2456 solution = new Solution2456();
        int[] value = {4, 1, 4, 0, 3, 5};
        int times = solution.distinctAverages(value);
        System.out.println(times);
    }

    @Test
    void distinctAveragesV1() {
        Solution2456 solution = new Solution2456();
        int[] value = {1,100};
        int times = solution.distinctAverages(value);
        System.out.println(times);
    }
}