package every233;

import java.util.TreeSet;

/**
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 * <p>
 * 实现 SmallestInfiniteSet 类：
 * <p>
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
 * 1 <= num <= 1000
 * 最多调用 popSmallest 和 addBack 方法 共计 1000 次
 */
public class Solution2336 {

}

class SmallestInfiniteSet {
    private int min;

    private TreeSet<Integer> adds;

    public SmallestInfiniteSet() {
        adds = new TreeSet<>();
        min = 1;
    }

    public int popSmallest() {
        int result;
        if (adds.isEmpty()) {
            min = min + 1;
            result = min;
        } else {
            result = adds.pollFirst();
            adds.remove(result);
        }
        return result;
    }

    public void addBack(int num) {
        if (num >= min) {
            return;
        }
        adds.add(num);
        Integer value;
        while (!adds.isEmpty()) {
            value = adds.pollLast();
            if (min - value == 1) {
                min = min - 1;
            } else {
                adds.add(value);
                break;
            }
        }
    }
}