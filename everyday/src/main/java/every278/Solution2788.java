package every278;

import java.util.ArrayList;
import java.util.List;

public class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>(words.size());
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c == separator) {
                    if (builder.length() > 0) {
                        res.add(builder.toString());
                        builder = new StringBuilder();
                    }
                    continue;
                }
                builder.append(c);
            }
            if (builder.length() > 0) {
                res.add(builder.toString());
            }
        }
        return res;
    }
}
