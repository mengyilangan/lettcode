package every217;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution2178Test {
    @Test
    public void test() {
        Solution2178 solution = new Solution2178();
        List<Long> list = solution.maximumEvenSplit(28);
        System.out.println(list);
    }
}