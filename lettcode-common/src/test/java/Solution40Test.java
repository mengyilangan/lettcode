import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution40Test {

    @Test
    void combinationSum2() {
        Solution40 solution = new Solution40();
        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        List<List<Integer>> result = solution.combinationSum2(arr, 8);
        System.out.println(result);
    }

    @Test
    void combinationSum3() {
        Solution40 solution = new Solution40();
        int[] arr = { 1, 2 };
        List<List<Integer>> result = solution.combinationSum2(arr, 4);
        System.out.println(result);
    }

    @Test
    void combinationSum4() {
        Solution40 solution = new Solution40();
        int[] arr = { 4, 4, 2, 1, 4, 2, 2, 1, 3 };
        List<List<Integer>> result = solution.combinationSum2(arr, 6);
        System.out.println(result);
    }
}
