package every067;

import java.util.Arrays;

public class Solution670 {
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        char[] words = String.valueOf(num).toCharArray();
        for (int i = 0; i < words.length; i++) {
            char c = words[i];
            if (c == '9') {
                continue;
            }

            int max = i;
            for (int j = words.length - 1; j > i; j--) {
                if (words[j] > words[max]) {
                    max = j;
                }
            }

            if (max > i) {
                char temp = words[i];
                words[i] = words[max];
                words[max] = temp;
                StringBuilder stringBuilder = new StringBuilder();
                for (char v : words) {
                    stringBuilder.append(v);
                }
                return Integer.parseInt(stringBuilder.toString());
            }
        }
        return num;
    }
}
