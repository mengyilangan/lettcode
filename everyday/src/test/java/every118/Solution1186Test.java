package every118;

import org.junit.jupiter.api.Test;

/**
 * 状态转移方程
 */
class Solution1186Test {
    @Test
    public void test() {
        Solution1186 solution = new Solution1186();
        //0
        //0,5
        int[] arr = {1, -4, -5, -2, 5, 0, -1, 2};
        int result = solution.maximumSum(arr);
        System.out.println(result);
    }
}