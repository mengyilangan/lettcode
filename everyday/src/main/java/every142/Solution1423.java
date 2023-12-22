package every142;

/**
 * https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/?envType=daily-question&envId=2023-12-03
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * 提示：
 * <p>
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 * <p>
 */
public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        //如果剩余的少,是不是剩余子数组的和最小即可?
        int length = cardPoints.length;
        if (k == length) {
            int sum = 0;
            for (int v : cardPoints) {
                sum += v;
            }
            return sum;
        }

        //只有一个
        if (k == 1) {
            return Math.max(cardPoints[0], cardPoints[length - 1]);
        }

        int left = length - k;
        if (left < k) {
            return maxScore(cardPoints, left, 0);
        }
        return maxScore(cardPoints, k, left - k);
    }

    public int maxScore(int[] cardPoints, int segmentLength, int jump) {
        int segmentSum = 0;
        for (int i = 0; i < segmentLength; i++) {
            segmentSum += cardPoints[i];
        }
        int allSum = segmentSum;
        int min = segmentSum;

        int distance = segmentLength + jump;
        //开始查找最小值;
        for (int i = distance; i < cardPoints.length; i++) {
            allSum += cardPoints[i];
            segmentSum = segmentSum - cardPoints[i - distance] + cardPoints[i];
            min = Math.min(min, segmentSum);
        }
        return allSum - min;
    }

}
