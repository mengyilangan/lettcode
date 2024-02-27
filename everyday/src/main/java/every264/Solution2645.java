package every264;

/**
 * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
 * <p>
 * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
 * 1 <= word.length <= 50
 * word 仅由字母 "a"、"b" 和 "c" 组成。
 */
public class Solution2645 {
    public int addMinimum(String word) {
        if (word.length() == 1) {
            return 2;
        }
        //最极端的情况下是需要插入 word.length()*2个字符;
        StringBuilder builder = new StringBuilder();
        char before = ' ';
        for (char c : word.toCharArray()) {
            switch (c) {
                case 'a':
                    openA(before, builder);
                    builder.append('a');
                    break;
                case 'b':
                    openB(before, builder);
                    builder.append('b');
                    break;
                case 'c':
                    openC(before, builder);
                    builder.append('c');
                    break;
            }
            before = c;
        }
        end(before, builder);
        return builder.length() - word.length();
    }

    public void end(char before, StringBuilder builder) {
        switch (before) {
            case ' ':
            case 'c':
                break;
            case 'a':
                builder.append('b').append('c');
                break;
            case 'b':
                builder.append('c');
        }
    }

    public void openC(char before, StringBuilder builder) {
        switch (before) {
            case 'c':
            case ' ':
                builder.append('a').append('b');
                break;
            case 'a':
                builder.append('b');
                break;
            default:
                break;
        }
    }

    //insertA
    public void openB(char before, StringBuilder builder) {
        switch (before) {
            case 'b':
                builder.append('c').append('a');
                break;
            case 'c':
            case ' ':
                builder.append('a');
                break;
            default:
                break;
        }
    }

    public void openA(char before, StringBuilder builder) {
        switch (before) {
            case 'a':
                builder.append('b').append('c');
                break;
            case 'b':
                builder.append('c');
                break;
            default:
                break;
        }
    }
}
