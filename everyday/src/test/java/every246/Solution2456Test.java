package every246;

import org.junit.jupiter.api.Test;

class Solution2456Test {

    @Test
    void distinctAverages() {
        Solution2465 solution = new Solution2465();
        int[] value = {4, 1, 4, 0, 3, 5};
        int times = solution.distinctAverages(value);
        System.out.println(times);
    }

    @Test
    void distinctAveragesV1() {
        Solution2465 solution = new Solution2465();
        int[] value = {1,100};
        int times = solution.distinctAverages(value);
        System.out.println(times);
    }
}