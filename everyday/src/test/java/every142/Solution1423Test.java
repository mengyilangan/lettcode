package every142;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 * <p>
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * 示例 2：
 * <p>
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * 示例 3：
 * <p>
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * 示例 4：
 * <p>
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * 示例 5：
 * <p>
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 */
class Solution1423Test {

    private Solution1423 solution = new Solution1423();

    @Test
    void maxScoreCase1() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int result = solution.maxScore(cardPoints, 3);
        Assertions.assertEquals(12, result);
    }

    @Test
    void maxScoreCase2() {
        int[] cardPoints = {2, 2, 2};
        int result = solution.maxScore(cardPoints, 2);
        Assertions.assertEquals(4, result);
    }

    @Test
    void maxScoreCase3() {
        int[] cardPoints = {9, 7, 7, 9, 7, 7, 9};
        int result = solution.maxScore(cardPoints, 7);
        Assertions.assertEquals(55, result);
    }

    @Test
    void maxScoreCase4() {
        int[] cardPoints = {1, 1000, 1};
        int result = solution.maxScore(cardPoints, 1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void maxScoreCase5() {
        int[] cardPoints = {1, 79, 80, 1, 1, 1, 200, 1};
        int result = solution.maxScore(cardPoints, 3);
        Assertions.assertEquals(202, result);
    }

    @Test
    void maxScoreCase6() {
        int[] cardPoints = {100, 40, 17, 9, 73, 75};
        int result = solution.maxScore(cardPoints, 3);
        Assertions.assertEquals(248, result);
    }

    @Test
    void maxScoreCase7() {
        int[] cardPoints = {11, 49, 100, 20, 86, 29, 72};
        int result = solution.maxScore(cardPoints, 4);
        Assertions.assertEquals(232, result);
    }
}