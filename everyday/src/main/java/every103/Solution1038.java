package every103;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/?envType=daily-question&envId=2023-12-04
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * <p>
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 提示：
 * <p>
 * 树中的节点数在 [1, 100] 范围内。
 * 0 <= Node.val <= 100
 * 树中的所有值均 不重复 。
 * <p>
 * 示例1
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * <p>
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 */
public class Solution1038 {

    public TreeNode build(int[] build) {
        TreeNode root = new TreeNode(build[0]);
        build(build, root, 0);
        return root;
    }

    private void build(int[] build, TreeNode root, int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        if (build.length <= left) {
            return;
        }
        if (build[left] != -1) {
            root.left = new TreeNode(build[left]);
            build(build, root.left, left);
        }

        if (build[right] != -1) {
            root.right = new TreeNode(build[right]);
            build(build, root.right, right);
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        traval(root, map);
        return root;
    }

    private void traval(TreeNode root, TreeMap<Integer, Integer> replace) {
        if (root.right != null) {
            traval(root.right, replace);
        }

        Map.Entry<Integer, Integer> entry = replace.higherEntry(root.val);

        if (entry != null) {
            int replaceValue = entry.getValue() + root.val;
            replace.put(root.val, replaceValue);
            root.val = replaceValue;
        } else {
            replace.put(root.val, root.val);
        }


        if (root.left != null) {
            traval(root.left, replace);
        }
    }
}
