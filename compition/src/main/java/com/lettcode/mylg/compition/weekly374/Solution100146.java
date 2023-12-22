package com.lettcode.mylg.compition.weekly374;

/**
 * https://leetcode.cn/contest/weekly-contest-374/problems/count-the-number-of-infection-sequences/
 * 给你一个整数 n 和一个下标从 0 开始的整数数组 sick ，数组按 升序 排序。
 * <p>
 * 有 n 位小朋友站成一排，按顺序编号为 0 到 n - 1 。数组 sick 包含一开始得了感冒的小朋友的位置。如果位置为 i 的小朋友得了感冒，他会传染给下标为 i - 1 或者 i + 1 的小朋友，前提 是被传染的小朋友存在且还没有得感冒。每一秒中， 至多一位 还没感冒的小朋友会被传染。
 * <p>
 * 经过有限的秒数后，队列中所有小朋友都会感冒。感冒序列 指的是 所有 一开始没有感冒的小朋友最后得感冒的顺序序列。请你返回所有感冒序列的数目。
 * <p>
 * 由于答案可能很大，请你将答案对 109 + 7 取余后返回。
 * <p>
 * 注意，感冒序列 不 包含一开始就得了感冒的小朋友的下标。
 * 2 <= n <= 105
 * 1 <= sick.length <= n - 1
 * 0 <= sick[i] <= n - 1
 * sick 按升序排列。
 */
public class Solution100146 {
    public int numberOfSequence(int n, int[] sick) {
        return 0;
    }
}
