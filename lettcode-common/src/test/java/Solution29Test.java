import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution29Test {

    Solution29 solution29 = new Solution29();

    @Test
    void divide() {
        Assertions.assertEquals(3, solution29.divide(10, 3));
        Assertions.assertEquals(-2, solution29.divide(7, -3));
    }

    @Test
    void divideV1() {
        System.out.println(1 << 30);
        Assertions.assertEquals(-2147483648 / 2, solution29.divide(-2147483648, 2));
    }
}
