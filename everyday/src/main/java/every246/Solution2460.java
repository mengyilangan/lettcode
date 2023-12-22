package every246;

public class Solution2460 {
    public int[] applyOperations(int[] nums) {
        if (nums.length == 1) {
            return nums;
        } else if (nums.length == 2 && nums[1] == 0) {
            return nums;
        }

        int minZero = -1;
        int count = nums.length == 0 ? 1 : 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                if (minZero < 0) {
                    minZero = i;
                }
                count += 1;
                continue;
            }

            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
                i = i + 1;
                count += 1;
                if (minZero < 0) {
                    minZero = i ;
                }
            }
        }

        if (count > 0 && minZero >= 0 && minZero + count < nums.length) {
            int forward = minZero;
            for (int i = minZero + 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                nums[forward] = nums[i];
                forward = forward + 1;
                nums[i] = 0;
            }
        }
        return nums;
    }
}
