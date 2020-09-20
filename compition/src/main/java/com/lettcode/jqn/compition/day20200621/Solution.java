package com.lettcode.jqn.compition.day20200621;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * 5441. 保证文件名唯一 显示英文描述
     * 题目难度Medium
     * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
     * <p>
     * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
     * <p>
     * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
     * <p>
     * 示例 1：
     * <p>
     * 输入：names = ["pes","fifa","gta","pes(2019)"]
     * 输出：["pes","fifa","gta","pes(2019)"]
     * 解释：文件系统将会这样创建文件名：
     * "pes" --> 之前未分配，仍为 "pes"
     * "fifa" --> 之前未分配，仍为 "fifa"
     * "gta" --> 之前未分配，仍为 "gta"
     * "pes(2019)" --> 之前未分配，仍为 "pes(2019)"
     * 示例 2：
     * <p>
     * 输入：names = ["gta","gta(1)","gta","avalon"]
     * 输出：["gta","gta(1)","gta(2)","avalon"]
     * 解释：文件系统将会这样创建文件名：
     * "gta" --> 之前未分配，仍为 "gta"
     * "gta(1)" --> 之前未分配，仍为 "gta(1)"
     * "gta" --> 文件名被占用，系统为该名称添加后缀 (k)，由于 "gta(1)" 也被占用，所以 k = 2 。实际创建的文件名为 "gta(2)" 。
     * "avalon" --> 之前未分配，仍为 "avalon"
     * 示例 3：
     * <p>
     * 输入：names = ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
     * 输出：["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
     * 解释：当创建最后一个文件夹时，最小的正有效 k 为 4 ，文件名变为 "onepiece(4)"。
     * 示例 4：
     * <p>
     * 输入：names = ["wano","wano","wano","wano"]
     * 输出：["wano","wano(1)","wano(2)","wano(3)"]
     * 解释：每次创建文件夹 "wano" 时，只需增加后缀中 k 的值即可。
     * 示例 5：
     * <p>
     * 输入：names = ["kaido","kaido(1)","kaido","kaido(1)"]
     * 输出：["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
     * 解释：注意，如果含后缀文件名被占用，那么系统也会按规则在名称后添加新的后缀 (k) 。
     *
     * @param names
     * @return
     */
    public String[] getFolderNames(String[] names) {
        if (names == null || names.length <= 1) {
            return names;
        }
        String[] dest = new String[names.length];
        Map<String, Times> occupy = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            // 精简模式的占用情况
            Pair<String, Integer> info = fileNameEnd(names[i]);
            if (info.snd != null && info.snd != 0) {
                // 是字符+数字的复合形式
                if (!occupy.containsKey(info.fst)) {
                    // 首次
                    occupy.put(info.fst, new Times(info.snd));
                    if (!occupy.containsKey(names[i])) {
                        occupy.put(names[i], new Times(0));
                        dest[i] = names[i];
                        continue;
                    }
                }

                if (occupy.get(info.fst).isOccupy(info.snd)) {
                    // 需要重复占用
                    if (occupy.containsKey(names[i])) {
                        occupy.get(names[i]).occupy(0);
                    }
                } else {
                    occupy.get(info.fst).occupy(info.snd);
                }
            }

            // 查看完整的占用情况,首次，直接返回
            if (!occupy.containsKey(names[i])) {
                occupy.put(names[i], new Times(0));
                dest[i] = names[i];
                continue;
            }

            // 首次
            int nextTimes = occupy.get(names[i]).nexMax;
            if (nextTimes == 0) {
                occupy.get(names[i]).occupy(0);
                dest[i] = names[i];
                continue;
            }

            String newFileName = names[i] + "(" + nextTimes + ")";
            occupy.get(names[i]).occupy(nextTimes);
            dest[i] = newFileName;
            if (occupy.containsKey(newFileName)) {
                occupy.get(newFileName).occupy(0);
            } else {
                occupy.put(newFileName, new Times(0));
            }
        }
        return dest;
    }

    Pair<String, Integer> fileNameEnd(String fileName) {
        if (fileName.endsWith(")")) {
            StringBuilder builder = new StringBuilder();
            for (int i = fileName.length() - 2; i >= 0; i--) {
                if (fileName.charAt(i) >= '0' && fileName.charAt(i) <= '9') {
                    builder.insert(0, fileName.charAt(i));
                } else if (fileName.charAt(i) == '(') {
                    if (builder.length() > 0) {
                        return Pair.of(fileName.substring(0, i), Integer.parseInt(builder.toString()));
                    }
                    return Pair.of(fileName, null);
                } else {
                    return Pair.of(fileName, null);
                }
            }
        }

        return Pair.of(fileName, null);
    }

    private static class Times {
        private Set<Integer> integers = new HashSet<>();

        private int nexMax = 0;

        public Times(int value) {
            occupy(value);
        }

        private boolean isOccupy(int integer) {
            return integers.contains(integer);
        }

        private void occupy(int integer) {
            integers.add(integer);
            if (integer == nexMax) {
                setNextMax();
            }
        }

        private void setNextMax() {
            do {
                nexMax++;
            } while (integers.contains(nexMax));
        }
    }

    private static class Pair<A, B> {
        private A fst;

        private B snd;

        public Pair(A var1, B var2) {
            this.fst = var1;
            this.snd = var2;
        }

        public static <A, B> Pair<A, B> of(A var0, B var1) {
            return new Pair<>(var0, var1);
        }
    }
}
