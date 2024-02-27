package every218;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2182Test {

    private Solution2182 solution = new Solution2182();

    @Test
    void repeatLimitedString() {
        String s = solution.repeatLimitedString("cczazcc", 3);
        System.out.println(s);
    }

    @Test
    void case2() {
        String s = solution.repeatLimitedString("aababab", 2);
        System.out.println(s);
    }

    @Test
    void case3() {
        String s = solution.repeatLimitedString("cczazcc", 3);
        System.out.println(s);
    }
}