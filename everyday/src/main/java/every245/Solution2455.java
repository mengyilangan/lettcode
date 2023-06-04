package every245;

public class Solution2455 {
    public int averageValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count += 1;
            }
        }
        return count > 0 ? sum / count : 0;
    }
}
