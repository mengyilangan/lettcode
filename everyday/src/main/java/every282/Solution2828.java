package every282;

import java.util.List;

public class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        int i = 0;
        for (char c : s.toCharArray()) {
            String word = words.get(i);
            if (word == null || word.length() == 0) {
                return false;
            }
            if (word.charAt(0) != c) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }
}
