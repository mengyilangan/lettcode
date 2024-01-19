package every118;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mylg
 * @date 31/12/23
 */
class Solution1185Test {

    private Solution1185 solution = new Solution1185();

    @Test
    public void case1() {
        //  输入：day = 31, month = 8, year = 2019
        //  输出："Saturday"
        String res = solution.dayOfTheWeek(31, 8, 2019);
        Assertions.assertEquals("Saturday", res);
    }

    @Test
    public void case2() {
        //输入：day = 18, month = 7, year = 1999
        String res = solution.dayOfTheWeek(18, 7, 1999);
        Assertions.assertEquals("Sunday", res);

    }

    @Test
    public void case3() {
        //输入：day = 18, month = 7, year = 1999
        String res = solution.dayOfTheWeek(15, 8, 1993);
        Assertions.assertEquals("Sunday", res);

    }

    @Test
    public void case4() {
        //输入：day = 18, month = 7, year = 1999
        String res = solution.dayOfTheWeek(29, 2, 2016);
        Assertions.assertEquals("Monday", res);
    }

    @Test
    public void case5() {
        //输入：day = 18, month = 7, year = 1999
        String res = solution.dayOfTheWeek(31, 8, 2100);
        Assertions.assertEquals("Tuesday", res);

    }
}
