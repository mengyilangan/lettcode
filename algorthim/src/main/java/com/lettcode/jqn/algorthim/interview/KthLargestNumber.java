package com.lettcode.jqn.algorthim.interview;

public class KthLargestNumber {
    public int sortK(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            int max = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            if (max > i) {
                int x = array[max];
                array[max] = array[i];
                array[i] = x;
            }
        }
        return array[k - 1];
    }

    public int sortInsertK(int[] array, int k) {
        //长度小于等于K
        if (array.length <= k || k == 1) {
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        }

        int[] sortArray = new int[k + 1];
        sortArray[1] = array[0];

        //初始化K个字符
        for (int i = 1; i < k; i++) {
            sortArray[0] = array[i];
            int j = i;
            while (sortArray[j] < array[i]) {
                sortArray[j + 1] = sortArray[j];
                j--;
            }
            sortArray[j + 1] = array[i];
        }

        for (int i = k; i < array.length; i++) {
            //不用插入
            if (sortArray[k] > array[i]) {
                continue;
            }
            int j = k - 1;
            sortArray[0] = array[i];
            while (sortArray[j] < sortArray[0]) {
                sortArray[j + 1] = sortArray[j];
                j--;
            }
            sortArray[j + 1] = array[i];
        }
        return sortArray[k];
    }

    /**
     * 堆是一个完全二叉树，所有结点都比根节点大或者所有节点都比根节点小
     * 假设K是大于array的长度的
     *
     * @param array
     * @param k
     */
    public int divideAndConquer(int[] array, int k) {
        k = array.length - k + 1;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            //算好了中间位置
            int index = indexComputeIndex(array, start, end);
            if (index == k - 1) {
                return array[index];
            }

            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return array[start];
    }

    /**
     * 选择快排
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int indexComputeIndex(int[] arr, int start, int end) {
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
        return j;
    }
}
