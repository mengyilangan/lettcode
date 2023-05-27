package every107;

public class Solution1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        } else if (arr2 == null || arr2.length == 0) {
            return arr1;
        }

        int max = Math.max(arr1.length, arr2.length);
        int[] valueArr = new int[max + 2];
        for (int i = 1; i <= arr1.length; i++) {
            int index = arr1.length - i;
            if (arr1[index] > 0) {
                valueArr[valueArr.length - i] = 1;
            }
        }

        for (int i = 1; i <= arr2.length; i++) {
            int index = arr2.length - i;
            if (arr2[index] > 0) {
                indexAddOne(valueArr, valueArr.length - i);
            }
        }

        int i = 0;
        for (; i < valueArr.length && valueArr[i] == 0; i++) ;
        int totalIndex = valueArr.length - i;
        if (totalIndex == 0) {
            return new int[1];
        }

        int[] result = new int[totalIndex];
        int j = -1;
        for (; i < valueArr.length; i++) {
            j++;
            result[j] = valueArr[i];
        }

        return result;
    }

    /**
     * 某一位+1
     *
     * @param value
     * @param index
     */
    private void indexAddOne(int[] value, int index) {
        if (value[index] == 0) {
            value[index] = 1;
            return;
        }

        if (value[index - 1] == 1) {
            value[index - 1] = 0;
            value[index] = 0;
            return;
        }

        value[index] = 0;
        value[index - 1] = 1;
        indexAddOne(value, index - 2);
    }
}
