package com.lettcode.jqn.algorthim.sort;

import java.util.Arrays;

public class ShellSequence {
    public void shellSort(int[] array) {
        int d = array.length;
        while (d > 1) {
            d = d / 2;
            //里面是插入排序，只是步长是d
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j = 0;
                    for (j = i - d; (j >= 0) && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        int[] array = {5, 3, 9, 12, 6, 1, 7, 2, 4, 11, 8, 10};
        ShellSequence sequence = new ShellSequence();
        sequence.shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
