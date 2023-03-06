package every1599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你正在经营一座摩天轮，该摩天轮共有 4 个座舱 ，每个座舱 最多可以容纳 4 位游客 。你可以 逆时针 轮转座舱，但每次轮转都需要支付一定的运行成本 runningCost 。摩天轮每次轮转都恰好转动 1 / 4 周。
 * <p>
 * 给你一个长度为 n 的数组 customers ， customers[i] 是在第 i 次轮转（下标从 0 开始）之前到达的新游客的数量。这也意味着你必须在新游客到来前轮转 i 次。每位游客在登上离地面最近的座舱前都会支付登舱成本 boardingCost ，一旦该座舱再次抵达地面，他们就会离开座舱结束游玩。
 * <p>
 * 你可以随时停下摩天轮，即便是 在服务所有游客之前 。如果你决定停止运营摩天轮，为了保证所有游客安全着陆，将免费进行所有后续轮转 。注意，如果有超过 4 位游客在等摩天轮，那么只有 4 位游客可以登上摩天轮，其余的需要等待 下一次轮转 。
 * <p>
 * 返回最大化利润所需执行的 最小轮转次数 。 如果不存在利润为正的方案，则返回 -1
 */
public class Solution {
    public int minOperationsMaxProfit(Integer[] customers, int boardingCost, int runningCost) {
        //没有客户来
        if (runningCost >= boardingCost * 4) {
            return -1;
        }
        List<Integer> profits = new ArrayList<Integer>(customers.length + 1);
        profits.add(0);

        int max = 0;
        int wait = 0;
        int round = -1;
        for (int customer : customers) {
            //截止目前总人数
            int has = customer + wait;
            //本次上线人数
            int on = Math.min(has, 4);
            //存储利润
            int profit = profits.get(profits.size() - 1) + on * boardingCost - runningCost;
            if (profit > max) {
                max = profit;
                round = profits.size();
            }
            profits.add(profit);
            wait = has - on;
        }

        int lastProfit = profits.get(profits.size() - 1);
        if (wait >= 4) {
            int run = wait / 4;
            lastProfit += run * (4 * boardingCost - runningCost);
            if (lastProfit > max) {
                max = lastProfit;
                round = profits.size() - 1 + run;
            }
            wait = wait % 4;
        }

        if (wait > 0) {
            lastProfit += wait * boardingCost - runningCost;
            if (lastProfit > max) {
                round += 1;
            }
        }
        return round;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int times;
        times = solution.minOperationsMaxProfit(Arrays.asList(8, 3).toArray(new Integer[0]), 5, 6);
        System.out.println("times=" + times + ",expect=3");
        times = solution.minOperationsMaxProfit(Arrays.asList(10, 9, 6).toArray(new Integer[0]), 6, 4);
        System.out.println("times=" + times + ",expect=7");

        times = solution.minOperationsMaxProfit(Arrays.asList(3, 4, 0, 5, 1).toArray(new Integer[0]), 1, 92);
        System.out.println("times=" + times + ",expect=-1");
        times = solution.minOperationsMaxProfit(Arrays.asList(5, 0, 0, 0, 0, 30).toArray(new Integer[0]), 5, 5);
        System.out.println("times=" + times + ",expect=13");
        times = solution.minOperationsMaxProfit(Arrays.asList(10, 10, 6, 4, 7).toArray(new Integer[0]), 5, 5);
        System.out.println("times=" + times + ",expect=9");
    }
}
