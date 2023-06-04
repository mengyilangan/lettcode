package every137;

import node.TreeNode;

public class Solution1373 {
    /**
     * 判断是否是搜索树,应该是从下往上找
     *
     * @return
     */
    public class TreeNodeRange {
        private int min;
        private int max;

        private boolean isSearch;

        private int sum;

        private int sumMax = 0;

        public TreeNodeRange(TreeNode treeNode) {
            this.min = treeNode.val;
            this.max = treeNode.val;
            this.isSearch = true;
            this.sum = treeNode.val;
        }
    }


    public TreeNodeRange compute(TreeNode treeNode) {
        TreeNodeRange result = new TreeNodeRange(treeNode);
        int sumMax = 0;
        if (treeNode.left != null) {
            TreeNodeRange left = compute(treeNode.left);
            result.isSearch = result.isSearch && left.isSearch && left.max < treeNode.val;
            result.min = left.min;
            result.sum += left.sum;
            sumMax = left.sumMax;
        }

        if (treeNode.right != null) {
            TreeNodeRange right = compute(treeNode.right);
            result.isSearch = result.isSearch && right.isSearch && right.min > treeNode.val;
            result.max = right.max;
            result.sum += right.sum;
            sumMax = Math.max(right.sumMax, sumMax);
        }

        if (result.isSearch) {
            sumMax = Math.max(sumMax, result.sum);
        }
        result.sumMax = sumMax;
        return result;
    }


    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNodeRange range = compute(root);
        return range.sumMax;
    }
}
