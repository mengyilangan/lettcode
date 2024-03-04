package com.lettcode.jqn.algorthim.sort;

import java.util.Arrays;

/**
 * @author mylg
 * @date 3/3/24
 */
public class MergeSequence {
    public void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public void merge(int[] array, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];
        int p = start;
        int q = mid + 1;
        int position = 0;
        while (p <= mid && q <= end) {
            if (array[p] <= array[q]) {
                tempArray[position] = array[p];
                p++;
            } else {
                tempArray[position] = array[q];
                q++;
            }
            position += 1;
        }

        while (p <= mid) {
            tempArray[position] = array[p];
            p++;
            position++;
        }

        while (q <= end) {
            tempArray[position] = array[q];
            q++;
            position++;
        }

        for (int i = 0; i < tempArray.length; i++) {
            array[i + start] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};
        MergeSequence sequence = new MergeSequence();
        sequence.mergeSort(array, 0, array.length - 1);
        System.out.printf(Arrays.toString(array));
    }
}
