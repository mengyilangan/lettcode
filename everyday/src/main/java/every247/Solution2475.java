package every247;

import java.util.*;

public class Solution2475 {
    public int unequalTriplets(int[] nums) {
        TreeMap<Integer, Integer> valueIndex = new TreeMap<>();
        int maxSize = 0;
        for (int num : nums) {
            int value = valueIndex.getOrDefault(num, 0) + 1;
            maxSize = Integer.max(maxSize, value);
            valueIndex.put(num, value);
        }

        if (valueIndex.size() < 3) {
            return 0;
        }
        if (valueIndex.size() == 3) {
            int value = 1;
            for (Map.Entry<Integer, Integer> entry : valueIndex.entrySet()) {
                value = entry.getValue() * value;
            }
            return value;
        }

        //Cmn
        if (maxSize == 1) {
            int k = Integer.min(valueIndex.size() - 3, 3);
            long divided = 1;
            long divisor = 1;
            for (int i = 1; i <= k; i++) {
                divisor = divisor * i;
                divided = divided * (valueIndex.size() - i + 1);
            }
            return (int) (divided / divisor);
        }

        //判断是否ok
        List<Integer> list = new ArrayList<>(valueIndex.keySet());
        int plus = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            int multiI = valueIndex.get(list.get(i));
            int value = 0;
            for (int j = i + 1; j < list.size() - 1; j++) {
                int multij = valueIndex.get(list.get(j));
                int sum = 0;
                for (int k = j + 1; k < list.size(); k++) {
                    sum += valueIndex.get(list.get(k));
                }
                value += multij * sum;
            }
            plus = plus + multiI * value;
        }

        return plus;
    }
}
