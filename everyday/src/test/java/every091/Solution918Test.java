package every091;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution918Test {

    @Test
    void maxSubarraySumCircular() {
        Solution918 solution918 = new Solution918();
        int[] nums = {1, -2, 3, -2};
        int result = solution918.maxSubarraySumCircular(nums);
        Assertions.assertEquals(3, result);
    }
}