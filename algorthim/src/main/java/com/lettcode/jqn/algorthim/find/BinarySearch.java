package com.lettcode.jqn.algorthim.find;

//二分法查找
public class BinarySearch {
    private final int[] arr;

    public BinarySearch(int[] arr) {
        this.arr = arr;
    }

    public int search(int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        BinarySearch search = new BinarySearch(arr);
        System.out.println(search.search(173));
        System.out.println(search.search(0));
        System.out.println(search.search(1000));
        System.out.println(search.search(999));
    }
}
