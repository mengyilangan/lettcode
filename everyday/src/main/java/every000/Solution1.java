package every000;

import java.util.*;

public class Solution1 {
    /**
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> valueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> minusHas = valueIndex.get(nums[i]);
            if (minusHas != null) {
                return new int[]{minusHas.get(0), i};
            }

            int minus = target - nums[i];
            minusHas = valueIndex.getOrDefault(minus, new ArrayList<>());
            minusHas.add(i);
            valueIndex.put(minus, minusHas);
        }
        return null;
    }
}
