package com.lettcode.jqn.algorthim.find;

/**
 * 字符串查找
 */
public class BFStrFind {
    public boolean contains(String main, String mode) {
        if (mode == null || main == null || mode.length() > main.length()) {
            return false;
        }
        for (int i = 0; i <= main.length() - mode.length(); i++) {
            if (isEqual(main, i, mode)) {
                return true;
            }
        }
        return false;
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
