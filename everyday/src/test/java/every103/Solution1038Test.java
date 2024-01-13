package every103;

import bean.TreeNode;
import org.junit.jupiter.api.Test;

class Solution1038Test {
    private Solution1038 solution = new Solution1038();

    @Test
    void bstToGst() {
        int[] value = {4, 1, 6, 0, 2, 5, 7, -1, -1, -1, 3, -1, -1, -1, 8};
        TreeNode root = TreeNode.build(value);
        root = solution.bstToGst(root);
    }
}