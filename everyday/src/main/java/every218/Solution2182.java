package every218;

public class Solution2182 {
    private static char[] DICTS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] index = new int[26];
        char first = 'a';
        int end = 0;
        for (char c : s.toCharArray()) {
            int i = c - first;
            index[i] += 1;
            end = Math.max(i, end);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = end; i >= 0; i--) {
            int value = index[i];
            boolean append = true;
            while (value > repeatLimit) {
                repeatWord(builder, i, repeatLimit);
                int nextFill = findNextIndex(index, i - 1);
                if (nextFill < 0) {
                    append = false;
                    break;
                }
                builder.append(DICTS[nextFill]);
                value -= repeatLimit;
            }

            if (append && value > 0) {
                repeatWord(builder, i, value);
            }
        }
        return builder.toString();
    }

    private void repeatWord(StringBuilder builder, int index, int repeat) {
        char c = DICTS[index];
        for (int i = 0; i < repeat; i++) {
            builder.append(c);
        }
    }

    private int findNextIndex(int[] index, int end) {
        while (end >= 0 && index[end] == 0) {
            end--;
        }
        if (end < 0) {
            return -1;
        }
        index[end] -= 1;
        return end;
    }
}
