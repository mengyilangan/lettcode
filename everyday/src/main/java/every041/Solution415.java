package every041;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        } else if (num2.length() == 0) {
            return num1;
        }

        String longth = num1;
        String shorth = num2;
        if (num1.length() < num2.length()) {
            longth = num2;
            shorth = num1;
        }

        StringBuilder builder = new StringBuilder(longth.length());
        int c = 0;
        int minus = longth.length() - shorth.length();
        for (int i = shorth.length() - 1; i >= 0; i--) {
            int a = shorth.charAt(i) - '0';
            int b = longth.charAt(i + minus) - '0';
            int sum = a + b + c;
            builder.insert(0, sum % 10);
            c = sum / 10;
        }
        int i = minus - 1;
        for (; c > 0 && i >= 0; i--) {
            int a = longth.charAt(i) - '0';
            int sum = a + c;
            builder.insert(0, sum % 10);
            c = sum / 10;
        }
        if (i >= 0) {
            builder.insert(0, longth.substring(0, i+1));
        }

        if (c > 0) {
            builder.insert(0, c);
        }
        return builder.toString();
    }


}
