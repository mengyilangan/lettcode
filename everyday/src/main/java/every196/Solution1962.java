package every196;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author mylg
 * @date 23/12/23
 */
public class Solution1962 {
    public int minStoneSum(int[] piles, int k) {
        int length = piles.length;
        if (length == 1) {
            int num = piles[0];
            for (int i = 0; i < k && num > 1; i++) {
                num = num - num / 2;
            }
            return num;
        }

        //从最后一个非叶节点开始构建大顶堆
        for (int i = piles.length / 2 - 1; i >= 0; i--) {
            maximumHeap(i, piles, length);
        }

        //从最小的叶子节点开始与根节点进行交换并重新构建大顶堆
        for (int i = 0; i < k; i++) {
            piles[0] -= piles[0] / 2;
            maximumHeap(0, piles, length);
        }
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        return sum;
    }

    //构建大顶堆
    private static void maximumHeap(int i, int[] arr, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //如果右孩子大于做孩子，则指向右孩子
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            //如果最大的孩子大于当前节点，则将大孩子赋给当前节点，修改当前节点为其大孩子节点，再向下走。
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i      = j;
            } else {
                break;
            }
        }
        //将temp放到最终位置
        arr[i] = temp;
    }

}
