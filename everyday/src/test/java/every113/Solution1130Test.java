package every113;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1130Test {

    @Test
    void mctFromLeafValues() {
        Solution1130 solution = new Solution1130();
        int[] arr = {1,10,11,8,12,14,1,15,3,11,6,12};
        int value = solution.mctFromLeafValues(arr);
        System.out.println(value);
    }


}