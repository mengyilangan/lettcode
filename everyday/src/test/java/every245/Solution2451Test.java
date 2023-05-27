package every245;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2451Test {
    private Solution2451 solution2451 = new Solution2451();

    @Test
    void oddString() {
        String[] words = {"adc", "wzy", "abc"};
        String result = solution2451.oddString(words);
        System.out.println(result);
    }
}