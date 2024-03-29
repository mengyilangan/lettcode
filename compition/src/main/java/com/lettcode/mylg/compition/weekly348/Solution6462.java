package com.lettcode.mylg.compition.weekly348;

/**
 * https://leetcode.cn/contest/weekly-contest-348/problems/minimize-string-length/
 * 给你一个下标从 0 开始的字符串 s ，重复执行下述操作 任意 次：
 * <p>
 * 在字符串中选出一个下标 i ，并使 c 为字符串下标 i 处的字符。并在 i 左侧（如果有）和 右侧（如果有）各 删除 一个距离 i 最近 的字符 c 。
 * 请你通过执行上述操作任意次，使 s 的长度 最小化 。
 * <p>
 * 返回一个表示 最小化 字符串的长度的整数。
 * 1 <= s.length <= 100
 * s 仅由小写英文字母组成
 */
public class Solution6462 {
    public int minimizedStringLength(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] character = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            character[index] = 1;
        }
        int sum = 0;
        for (int i = 0; i < character.length; i++) {
            sum += character[i];
        }
        return sum;
    }
}
