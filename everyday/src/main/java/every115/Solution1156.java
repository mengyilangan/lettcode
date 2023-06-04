package every115;

import every137.Solution1373;

import java.util.*;

/**
 * https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 */
public class Solution1156 {
    public int maxRepOpt1(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        TreeMap<Integer, WordCount> treeMap = new TreeMap<>();
        int upperLimit = 0;
        int[] charTotalCount = new int[26];
        for (int i = 0; i < text.length(); ) {
            //第一个字段走到了倒数第一个字符
            WordCount wordCount = findEnd(i, text);
            treeMap.put(i, wordCount);
            i = wordCount.end;

            //每个字符的个数
            int index = wordCount.c - 'a';
            charTotalCount[index] += wordCount.count;
            upperLimit = Math.max(charTotalCount[index], upperLimit);
        }

        if (upperLimit >= text.length() - 1 || upperLimit == 1) {
            return upperLimit;
        }

        //2b4a2b2c2b
        int max = 1;
        for (Map.Entry<Integer, WordCount> entry : treeMap.entrySet()) {
            WordCount a = entry.getValue();
            WordCount b = treeMap.get(a.end);
            if (b == null) {
                if (max <= a.count) {
                    int index = a.c - 'a';
                    if (charTotalCount[index] > a.count) {
                        max = a.count + 1;
                    }
                }
                break;
            }

            WordCount rightA = treeMap.get(b.end);
            if (b.count > 1 || rightA == null || rightA.c != a.c) {
                //A*****B****模式
                if (max <= a.count) {
                    int index = a.c - 'a';
                    max = a.count;
                    if (charTotalCount[index] > a.count) {
                        max = a.count + 1;
                        if (max >= upperLimit) {
                            break;
                        }
                    }
                }
                continue;
            }

            //A******BA******模式
            int sum = a.count + rightA.count;
            if (sum >= upperLimit) {
                max = upperLimit;
                break;
            }

            if (sum < max) {
                //这个模式不够大,忽略
                continue;
            }
            int index = a.c - 'a';
            if (charTotalCount[index] > sum) {
                max = sum + 1;
                if (max >= upperLimit) {
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 查找第一个A*B
     * 向后浏览到A(1,*)BA(1,*)
     *
     * @param start
     * @param text
     * @return
     */

    public WordCount findEnd(int start, String text) {
        if (start >= text.length()) {
            return null;
        }
        char first = text.charAt(start);
        int i = start + 1;
        for (; i < text.length(); i++) {
            if (text.charAt(i) != first) {
                break;
            }
        }
        return new WordCount(first, i - start, i);
    }

    public static class WordCount {
        private char c;

        private int count;

        private int end;

        public WordCount(char c, int count, int end) {
            this.c = c;
            this.count = count;
            this.end = end;
        }
    }
}
