package every217;

import every004.Solution2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mylg
 * @date 19/1/24
 */
class Solution2171Test {

    private Solution2171 solution = new Solution2171();

    /**
     * 输入：beans = [4,1,6,5]
     * 输出：4
     * 解释：
     * - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
     * 剩下袋子中魔法豆的数目为：[4,0,6,5]
     * - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
     * 剩下袋子中魔法豆的数目为：[4,0,4,5]
     * - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
     * 剩下袋子中魔法豆的数目为：[4,0,4,4]
     * 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
     * 没有比取出 4 个魔法豆更少的方案。
     */
    @Test
    void case1() {
        int[] beans = { 4, 1, 6, 5 };
        long res = solution.minimumRemoval(beans);
        Assertions.assertEquals(4L, res);
    }

    @Test
    void case2() {
        int[] beans = { 2, 10, 3, 2 };
        long res = solution.minimumRemoval(beans);
        Assertions.assertEquals(7L, res);
    }

    @Test
    void case3() {
        int[] beans = { 66, 90, 47, 25, 92, 90, 76, 85, 22, 3 };
        Arrays.sort(beans);
        //3, 22, 25, 47, 66, 76, 85, 90, 90, 92
        long res = solution.minimumRemoval(beans);
        Assertions.assertEquals(200L, res);
    }
}
