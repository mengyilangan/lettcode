package every196;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mylg
 * @date 24/12/23
 */
class Solution1962Test {

    private Solution1962 solution = new Solution1962();

    @Test
    void minStoneSum() {
        int[] a = { 5, 4, 9 };
        int res = solution.minStoneSum(a, 2);
        System.out.println(res);
    }
}
