package every126;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1262Test {

    @Test
    void maxSumDivThree() {
        Solution1262 solution = new Solution1262();
        //2,8,32,38,
        //13,40
        int[] nums = {2, 3, 36, 8, 32, 38, 3, 30, 13, 40};
        int result = solution.maxSumDivThree(nums);
        //1,1,4,7
        //5
        System.out.println(result);
    }
}