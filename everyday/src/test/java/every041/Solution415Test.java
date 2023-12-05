package every041;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution415Test {

    @Test
    void addStrings() {
        Solution415 solution = new Solution415();
        String result = solution.addStrings("11", "123");
        Assertions.assertEquals("134", result);
    }

    @Test
    void addStringsCase2() {
        Solution415 solution = new Solution415();
        String result = solution.addStrings("456", "77");
        Assertions.assertEquals("533", result);
    }

    @Test
    void addStringsCase3() {
        Solution415 solution = new Solution415();
        String result = solution.addStrings("0", "0");
        Assertions.assertEquals("0", result);
    }
}