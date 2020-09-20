import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution56Test {
    Solution56 solution56 = new Solution56();

    @Test
    void merge() {
        int[][] intervals = new int[][]{ { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(solution56.merge(intervals)));
    }
}
