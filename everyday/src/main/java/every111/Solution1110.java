package every111;

import node.TreeNode;

import java.util.*;

public class Solution1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Queue<TreeNode> split = new ArrayDeque<>();
        List<TreeNode> result = new ArrayList<>();
        if (to_delete == null || to_delete.length == 0) {
            result.add(root);
            return result;
        }

        Set<Integer> deleteSets = new HashSet<>();
        for (int delete : to_delete) {
            deleteSets.add(delete);
        }
        split.add(root);
        delNodes(split, deleteSets, result);
        return result;
    }

    public void delNodes(Queue<TreeNode> split, Set<Integer> deleteSets, List<TreeNode> result) {
        if (split.isEmpty()) {
            return;
        }


        while (!split.isEmpty() && !deleteSets.isEmpty()) {
            TreeNode root = split.poll();
            boolean notEmpty = preRoot(root, split, deleteSets);
            if (notEmpty) {
                result.add(root);
            }
        }

        while (deleteSets.isEmpty() && !split.isEmpty()) {
            TreeNode root = split.poll();
            result.add(root);
        }
    }

    public boolean preRoot(TreeNode root, Queue<TreeNode> split, Set<Integer> deleteSets) {
        if (root == null) {
            return false;
        }

        if (deleteSets.remove(root.val)) {
            addChildren(root, split);
            return false;
        }
        preChild(root, split, deleteSets);
        return true;
    }

    private void addChildren(TreeNode root, Queue<TreeNode> split) {
        if (root.left != null) {
            split.add(root.left);
        }

        if (root.right != null) {
            split.add(root.right);
        }
    }


    public void preChild(TreeNode root, Queue<TreeNode> split, Set<Integer> deleteSets) {
        if (deleteSets.isEmpty()) {
            return;
        }

        if (root.left != null) {
            TreeNode left = root.left;
            if (deleteSets.remove(left.val)) {
                addChildren(root.left, split);
                root.left = null;
                if (deleteSets.isEmpty()) {
                    return;
                }
            } else {
                preChild(root.left, split, deleteSets);
            }
        }

        if (root.right != null) {
            TreeNode right = root.right;
            if (deleteSets.remove(right.val)) {
                addChildren(root.right, split);
                root.right = null;
            } else {
                preChild(root.right, split, deleteSets);
            }
        }
    }
}
