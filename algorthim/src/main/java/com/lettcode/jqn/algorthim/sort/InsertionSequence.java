package com.lettcode.jqn.algorthim.sort;

/**
 * 从前往后逐一插入
 *
 * @author jiangqiaonan
 * @date 2020-09-20
 */
public class InsertionSequence {
    public static void sort(int[] a) {
        //将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //将a[i]插入到a[i-1]，a[i-2]，a[i-3]……之中
            for (int j = i; j > 0 && a[j] < (a[j - 1]); j--) {
                int temp = a[j];
                a[j]     = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }
}
