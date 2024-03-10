package every093;

import bean.TreeNode;

/**
 * https://leetcode.cn/problems/range-sum-of-bst/?envType=daily-question&envId=2024-02-27
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 * @author mylg
 * @date 27/2/24
 */
public class Solution938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        int sum = 0;
        if (low <= root.val && high >= root.val) {
            sum += root.val;
        }
        return sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
