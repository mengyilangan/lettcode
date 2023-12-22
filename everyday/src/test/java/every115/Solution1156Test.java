package every115;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1156Test {

    @Test
    void maxRepOpt1() {
        Solution1156 solution = new Solution1156();
        int value = solution.maxRepOpt1("ababa");
        System.out.println(value);
    }

    @Test
    void maxRepOpt1Case1() {
        Solution1156 solution = new Solution1156();
        int value = solution.maxRepOpt1("bbaaaabbccbb");
        System.out.println(value);
    }
}