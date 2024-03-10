package string;

public class Solution {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "race a car"
     * 输出: false
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (end > 0 && !Character.isLetterOrDigit(s.charAt(end))) end--;
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            if (start >= end) {
                return true;
            }
            char first = Character.toLowerCase(s.charAt(start));
            char last = Character.toLowerCase(s.charAt(end));
            if (first != last) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
