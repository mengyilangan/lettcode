package com.lettcode.jqn.algorthim.sort;

/**
 * 从后往前排，最后一个最大or最小;
 * 冒牌
 *
 * @author jiangqiaonan
 * @date 2020-09-20
 */
public class BubblingSequence {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;
                }
            }
        }
    }
}
