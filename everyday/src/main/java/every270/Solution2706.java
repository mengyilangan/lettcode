package every270;

/**
 * @author mylg
 * @date 29/12/23
 */
public class Solution2706 {
    public int buyChoco(int[] prices, int money) {
        if (prices.length <= 1) {
            return money;
        }

        int first = prices[0];//最小
        int second = prices[1];//其次
        if (second < first) {
            first  = prices[1];
            second = prices[0];
        }

        for (int i = 2; i < prices.length; i++) {
            if (prices[i] >= second) {
                continue;
            }

            if (prices[i] < first) {
                second = first;
                first  = prices[i];
            } else {
                second = prices[i];
            }
        }

        int consume = first + second;
        int left = money - consume;
        return left >= 0 ? left : money;
    }
}
