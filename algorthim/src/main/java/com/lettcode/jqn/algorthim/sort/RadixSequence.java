package com.lettcode.jqn.algorthim.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSequence {
    public static final int ASCII_RANGE = 128;

    public String[] radixSort(String[] array, int maxLength) {
        String[] sortedArray = new String[array.length];
        for (int k = maxLength; k >= 0; k--) {
            int[] count = new int[ASCII_RANGE];
            for (int i = 0; i < array.length; i++) {
                int index = getCharIndex(array[i], k);
                count[index]++;
            }

            //决定了该数值在第几位,count决定该字符在第几位
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }

            //这相当于是map[其实成本相当于高了]
            for (int i = array.length - 1; i >= 0; i--) {
                int index = getCharIndex(array[i], k);
                int sortedIndex = count[index] - 1;
                sortedArray[sortedIndex] = array[i];
                count[index]--;
            }
            array = sortedArray.clone();
        }
        return array;
    }


    private int getCharIndex(String str, int k) {
        if (str.length() < (k + 1)) {
            return 0;
        }
        return str.charAt(k);
    }


    public static void main(String[] args) {
        String[] array = {"qd", "abc", "qwe", "hhh", "a", "cws", "ope"};
        System.out.println(Arrays.toString(new RadixSequence().radixSort(array, 3)));
    }
}
