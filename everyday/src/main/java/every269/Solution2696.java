package every269;

import java.util.Stack;

public class Solution2696 {

    public int minLength(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int sum = 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            //是一个不能删的字符串
            if (chars[i] > 'D') {
                sum = sum + stack.size() + 1;
                stack.clear();
                continue;
            }

            if (chars[i] == 'A' || chars[i] == 'C') {
                stack.push(chars[i]);
                continue;
            }

            if (stack.size() == 0) {
                sum += 1;
                continue;
            }

            Character character = stack.pop();
            if (chars[i] - character == 1) {
                //是一对
                continue;
            } else {
                //不是一对
                stack.push(character);
                stack.push(chars[i]);
            }

        }
        return sum + stack.size();
    }

    private int computeLeft(Stack<Character> stack) {
        return stack.size();
    }
}
