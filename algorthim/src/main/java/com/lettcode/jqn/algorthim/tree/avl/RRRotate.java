package com.lettcode.jqn.algorthim.tree.avl;

/**
 * 右右
 */
public class RRRotate implements Rotate {
    @Override
    public AVLNode rotateNewRoot(AVLNode root) {
        AVLNode nextRoot = root.right;
        root.right = nextRoot.left;
        nextRoot.left = root;
        //重置平衡度和深度
        root.resetDeptBalance();
        nextRoot.resetDeptBalance();
        return nextRoot;
    }
}
