package com.lettcode.jqn.algorthim.tree.avl;

/**
 * 右左,先右,变成右右,再左旋
 */
public class RLRotate implements Rotate {
    @Override
    public AVLNode rotateNewRoot(AVLNode root) {
        AVLNode rotateNode = root.right;
        AVLNode newRight = rotateNode.left;
        rotateNode.left = newRight.right;
        newRight.right = rotateNode;
        root.left = newRight;
        rotateNode.resetDeptBalance();
        newRight.resetDeptBalance();
        return new RRRotate().rotateNewRoot(root);
    }
}
