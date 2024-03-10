package every217;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * <p>
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * <p>
 * 请返回你需要拿出魔法豆的 最少数目。
 * <p>
 * 1 <= beans.length <= 105
 * 1 <= beans[i] <= 105
 *
 * @author mylg
 * @date 18/1/24
 */
public class Solution2171 {
    public long minimumRemoval(int[] beans) {

        //从小到大来,看的是要几,
        // 对于其他数而言:
        // 小的直接选择放弃,大于这个值的就是减去超过部分,看标准值是哪个数
        //sumAll-(n-i)*bean.length-beans.length
        Arrays.sort(beans);
        long max = 0;
        long all = 0;
        int n = beans.length;
        for (int i = 0; i < beans.length; i++) {
            all += beans[i];
            max = Math.max((long) (n - i) * beans[i], max);
        }
        return all - max;
    }
}
