package com.lettcode.mylg.compition.weekly355;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution6921 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        if (words == null || words.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            StringBuilder buffer = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c == separator) {
                    if (buffer.length() == 0) {
                        continue;
                    }
                    result.add(buffer.toString());
                    buffer = new StringBuilder();
                }
                buffer.append(c);
            }

            if (buffer.length() != 0) {
                result.add(buffer.toString());
            }
        }
        return result;
    }
}
