package com.lettcode.jqn.algorthim.find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//o(m+n)先hash，再逐步比较
public class RKStrFind {
    private static final Map<Character, Integer> CHARACTER_INDEX = new HashMap<>();

    static {
        List<Character> characterList = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        for (int i = 0; i < characterList.size(); i++) {
            CHARACTER_INDEX.put(characterList.get(i), i);
        }
    }

    public boolean contains(String main, String mode) {
        if (mode == null || main == null || mode.length() > main.length()) {
            return false;
        }
        int modeHashCode = computeHashCode(mode, mode.length());
        int firstHashCode = computeHashCode(main, mode.length() - 1);
        int before = 0;
        int end = mode.length() - 2;
        for (int i = 0; i <= main.length() - mode.length(); i++) {
            end = end + 1;
            int add = CHARACTER_INDEX.get(main.charAt(end));
            firstHashCode = firstHashCode + add - before;
            before = CHARACTER_INDEX.get(main.charAt(i));
            if (firstHashCode == modeHashCode) {
                if (isEqual(main, i, mode)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int computeHashCode(String main, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += CHARACTER_INDEX.get(main.charAt(i));
        }
        return sum;
    }

    private boolean isEqual(String main, int start, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            if (main.charAt(i + start) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
