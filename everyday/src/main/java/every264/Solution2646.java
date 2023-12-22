package every264;

/**
 * https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/?envType=daily-question&envId=2023-12-06
 * 现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
 * <p>
 * 每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。
 * <p>
 * 给定路径的 价格总和 是该路径上所有节点的价格之和。
 * <p>
 * 另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何你喜欢的路径前往节点 endi 。
 * <p>
 * 在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。
 * <p>
 * 返回执行所有旅行的最小价格总和。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * edges.length == n - 1
 * 0 <= ai, bi <= n - 1
 * edges 表示一棵有效的树
 * price.length == n
 * price[i] 是一个偶数
 * 1 <= price[i] <= 1000
 * 1 <= trips.length <= 100
 * 0 <= starti, endi <= n - 1
 */
public class Solution2646 {

}
