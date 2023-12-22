package every185;

import every004.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution1851Test {

    @Test
    void minInterval() {
        Solution1851 solution = new Solution1851();
        //：intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2};
        int[] value = solution.minInterval(intervals, queries);
        System.out.println(Arrays.toString(value));
    }
}