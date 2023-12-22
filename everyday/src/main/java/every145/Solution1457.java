package every145;

import bean.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/?envType=daily-question&envId=2023-11-25
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * 提示：
 * <p>
 * 给定二叉树的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 9
 */
public class Solution1457 {

    /**
     * 在所有的到叶子路径中，存在(2*n)1路径的为伪回文路径
     * 超出内存限制，怎么用异或
     *
     * @param root
     * @return
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        //只有一个叶子节点
        if (root == null) {
            return 0;
        }
        //只有一个根
        if (root.left == null && root.right == null) {
            return 1;
        }


       /* List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        traversal(list, stack, root);
        return isRecycle(list);*/
        Map<Integer, Integer> count = new HashMap<>();
        return traversal(0, count, root);
    }

    public int traversal(int before, Map<Integer, Integer> has, TreeNode root) {
        if (root.left == null && root.right == null) {
            if (before == 0) {
                return 1;
            }
            int value = before ^ (2 << root.val);
            if (has.containsKey(value) || value == 0) {
                return 1;
            }
            return 0;
        }
        int beforeCount = has.getOrDefault(root.val, 0);
        has.put(root.val, beforeCount + 1);
        before = before ^ (2 << root.val);
        int value = 0;
        if (root.left != null) {
            value = traversal(before, has, root.left);
        }
        if (root.right != null) {
            value += traversal(before, has, root.right);
        }
        if (beforeCount == 0) {
            has.remove(value);
        } else {
            has.put(root.val, beforeCount);
        }
        return value;
    }


    public void traversal(List<List<Integer>> list, Stack<Integer> stack, TreeNode root) {
        if (root.left == null && root.right == null) {
            List<Integer> line = new ArrayList<>(stack);
            line.add(root.val);
            list.add(line);
            return;
        }

        stack.push(root.val);
        if (root.left != null) {
            traversal(list, stack, root.left);
        }
        if (root.right != null) {
            traversal(list, stack, root.right);
        }
        stack.pop();
    }

    public int isRecycle(List<List<Integer>> list) {
        int sum = 0;
        for (List<Integer> line : list) {
            Set<Integer> has = new HashSet<>();
            for (int value : line) {
                if (!has.add(value)) {
                    has.remove(value);
                }
            }
            if (has.size() <= 1) {
                sum += 1;
            }
        }
        return sum;
    }
}
