package every012;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，
 * 返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 * https://leetcode.cn/problems/word-ladder/
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //直接没有
        Set<String> wordSets = new HashSet<>(wordList);
        if (!wordSets.contains(endWord)) {
            return 0;
        }

        //构建无向图,寻找无向图的最短路径
        return 0;
    }


    public static class Word {
        /**
         * 起点
         */
        private String start;

        /**
         * 可以的重点
         */
        private Set<String> destination;
    }


    /**
     * 一共是26个字母
     */
    public static class WordDesc {


    }

}
