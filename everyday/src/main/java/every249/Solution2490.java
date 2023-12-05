package every249;

/**
 * https://leetcode.cn/problems/circular-sentence/
 * <p>
 * 句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
 * <p>
 * 例如，"Hello World"、"HELLO"、"hello world hello world" 都是符合要求的句子。
 * 单词 仅 由大写和小写英文字母组成。且大写和小写字母会视作不同字符。
 * <p>
 * 如果句子满足下述全部条件，则认为它是一个 回环句 ：
 * <p>
 * 单词的最后一个字符和下一个单词的第一个字符相等。
 * 最后一个单词的最后一个字符和第一个单词的第一个字符相等。
 * 例如，"leetcode exercises sound delightful"、"eetcode"、"leetcode eats soul" 都是回环句。然而，"Leetcode is cool"、"happy Leetcode"、"Leetcode" 和 "I like Leetcode" 都 不 是回环句。
 * <p>
 * 给你一个字符串 sentence ，请你判断它是不是一个回环句。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/circular-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 1 <= sentence.length <= 500
 * sentence 仅由大小写英文字母和空格组成
 * sentence 中的单词由单个空格进行分隔
 * 不含任何前导或尾随空格
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/circular-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2490 {
    public boolean isCircularSentence(String sentence) {
        if (sentence.length() <= 1) {
            return true;
        }

        int length = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(length - 1)) {
            return false;
        }

        for (int i = 1; i < length - 1; i++) {
            if (sentence.charAt(i) == ' ') {
                char before = sentence.charAt(i - 1);
                char after = sentence.charAt(i + 1);
                if (before != after) {
                    return false;
                }
            }
        }
        return true;
    }
}
