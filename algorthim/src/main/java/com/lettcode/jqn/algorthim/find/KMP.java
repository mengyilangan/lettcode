package com.lettcode.jqn.algorthim.find;

public class KMP {

    public int indexOf(String main, String mod) {
        int[] next = generateNext(mod);
        int j = 0;
        for (int i = 0; i < main.length(); i++) {
            while ((j > 0) && (main.charAt(i) != mod.charAt(j))) {
                j = next[j];
            }

            if (main.charAt(i) == mod.charAt(j)) {
                j++;
            }

            if (j == mod.length()) {
                return i - mod.length() + 1;
            }
        }
        return -1;
    }

    /**
     * 生成next数组
     *
     * @param s
     * @return
     */
    public int[] generateNext(String s) {
        if (s == null) {
            return null;
        }
        int[] next = new int[s.length()];
        if (s.length() <= 2) {
            return next;
        }

        char[] words = s.toCharArray();

        int j = 0;
        for (int i = 2; i < words.length; i++) {
            char iBefore = words[i - 1];
            while (j >= 0) {
                if (iBefore == words[j]) {
                    j++;
                    next[i] = j;
                    break;
                }

                if (j == 0) {
                    break;
                }
                j = next[j];
            }
        }
        return next;
    }
}
