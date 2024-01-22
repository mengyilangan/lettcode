package com.lettcode.mylg.compition.weekly380;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 给你一个下标从 0 开始的字符串 s 、字符串 a 、字符串 b 和一个整数 k 。
 * <p>
 * 如果下标 i 满足以下条件，则认为它是一个 美丽下标：
 * <p>
 * 0 <= i <= s.length - a.length
 * s[i..(i + a.length - 1)] == a
 * 存在下标 j 使得：
 * 0 <= j <= s.length - b.length
 * s[j..(j + b.length - 1)] == b
 * |j - i| <= k
 * 以数组形式按 从小到大排序 返回美丽下标。
 * 提示：
 * <p>
 * 1 <= k <= s.length <= 105
 * 1 <= a.length, b.length <= 10
 * s、a、和 b 只包含小写英文字母。
 */
public class Solution100165 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        //这两个直接相等
        if (a.equals(b)) {
            return beautifulIndices(s, a);
        } else if (a.contains(b) && a.indexOf(b) < k) {
            return beautifulIndices(s, a);
        }

        List<Integer> res = new ArrayList<>();
        int start = 0;
        TreeSet<Integer> bIndex = new TreeSet<>();
                      while ((start = s.indexOf(a, start)) >= 0) {

            //查找b

        }
        return res;
    }

    private List<Integer> beautifulIndices(String s, String a) {
        List<Integer> res = new ArrayList<>();
        int start = 0;
        while ((start = s.indexOf(a, start)) >= 0) {
            res.add(start);
            start += a.length();
        }
        return res;
    }
}
