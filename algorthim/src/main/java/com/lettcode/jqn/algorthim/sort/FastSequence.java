package com.lettcode.jqn.algorthim.sort;

/**
 * 快速排序
 * 递归
 *
 * @author jiangqiaonan
 * @date 2020-09-20
 */
public class FastSequence {
    public static void sort(int []arr) {
        int len = arr.length-1;
        sort(arr,0,len);
    }

    private static int[] sort(int []arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) arr = sort(arr, start, i - 1);
        if (j + 1 < end) arr = sort(arr, j + 1, end);
        return (arr);
    }
}
