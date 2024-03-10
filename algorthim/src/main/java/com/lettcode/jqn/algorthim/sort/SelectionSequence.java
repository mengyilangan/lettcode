package com.lettcode.jqn.algorthim.sort;

/**
 * 选择排序：和冒泡排序有些相似;一个是一直更换，一个是选出最大的在更换
 * @author jiangqiaonan
 * @date 2020-09-20
 */
public class SelectionSequence {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //需要比较的次数，数组长度减一先假设每次循环时，最小数的索引为i
            int minIndex = i;
            //每一个元素都和剩下的未排序的元素比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {//寻找最小数
                    minIndex = j;//将最小数的索引保存
                }
            }
            //经过一轮循环，就可以找出第一个最小值的索引，然后把最小值放到i的位置
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
