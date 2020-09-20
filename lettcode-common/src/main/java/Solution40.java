import java.util.*;

public class Solution40 {
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        int[] sum = new int[candidates.length];
        sum[candidates.length - 1] = candidates[candidates.length - 1];
        for (int i = candidates.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + candidates[i];
        }
        List<List<Integer>> result = combinationSum2(candidates, target, 0, sum);
        if (!result.isEmpty()) {
            Map<Integer, List<List<Integer>>> reference = new HashMap<>();
            List<List<Integer>> duplicate = new ArrayList<>();
            for (List<Integer> item : result) {
                if (isMissing(reference, item)) {
                    duplicate.add(item);
                    List<List<Integer>> referenceItem = reference.getOrDefault(item.size(), new ArrayList<>());
                    referenceItem.add(item);
                    reference.put(item.size(), referenceItem);
                }
            }
            return duplicate;
        }
        return result;
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target, int start, int[] sum) {
        if (candidates.length <= start || candidates[start] > target || sum[start] < target) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] < target) {
                List<List<Integer>> response = combinationSum2(candidates, target - candidates[i], i + 1, sum);
                if (!response.isEmpty()) {
                    for (List<Integer> list : response) {
                        list.add(candidates[i]);
                        result.add(list);
                    }
                }
            } else if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                result.add(list);
            } else {
                break;
            }
        }
        return result;
    }


    private boolean isMissing(Map<Integer, List<List<Integer>>> listMap, List<Integer> list) {
        if (listMap.isEmpty() || !listMap.containsKey(list.size())) {
            return true;
        }
        for (List<Integer> reference : listMap.get(list.size())) {
            if (reference.containsAll(list) && list.containsAll(reference))
                return false;
        }
        return true;
    }
}
