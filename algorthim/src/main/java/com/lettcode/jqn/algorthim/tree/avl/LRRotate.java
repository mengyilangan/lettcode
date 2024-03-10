package com.lettcode.jqn.algorthim.tree.avl;

/**
 * 左右,先左,变成左左
 */
public class LRRotate implements Rotate {
    @Override
    public AVLNode rotateNewRoot(AVLNode root) {
        AVLNode rotateNode = root.left;
        AVLNode newLeft = rotateNode.right;
        rotateNode.right = newLeft.left;
        newLeft.left = rotateNode;
        root.left = newLeft;
        rotateNode.resetDeptBalance();
        newLeft.resetDeptBalance();
        return new LLRotate().rotateNewRoot(root);
    }
}
