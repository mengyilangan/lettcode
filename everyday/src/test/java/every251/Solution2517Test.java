package every251;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2517Test {

    @Test
    void maximumTastiness() {
        Solution2517 solution = new Solution2517();
        int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3;
        int value = solution.maximumTastiness(price, k);
        System.out.printf("结果是%d", value);
    }
}