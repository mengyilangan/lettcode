package com.lettcode.mylg.compition.weekly374;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
 * <p>
 * 以数组形式返回给定数组中 峰值 的下标，顺序不限 。
 * <p>
 * 注意：
 * <p>
 * 峰值 是指一个严格大于其相邻元素的元素。
 * 数组的第一个和最后一个元素 不 是峰值。
 * 输入：mountain = [1,4,3,8,5]
 * 输出：[1,3]
 * 解释：mountain[0] 和 mountain[4] 不可能是峰值，因为它们是数组的第一个和最后一个元素。
 * mountain[2] 也不可能是峰值，因为它不严格大于 mountain[3] 和 mountain[1] 。
 * 但是 mountain[1] 和 mountain[3] 严格大于它们的相邻元素。
 * 因此，答案是 [1,3] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= mountain.length <= 100
 * 1 <= mountain[i] <= 100
 */
public class Solution100144 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < mountain.length; i++) {
            if (mountain[i - 1] > mountain[i] && mountain[i - 1] > mountain[i - 2]) {
                result.add(i-1);
            }
        }
        return result;
    }
}
