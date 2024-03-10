package com.lettcode.jqn.algorthim.tree.avl;

/**
 * 左旋生成新的根节点
 */
public class LLRotate implements Rotate {
    @Override
    public AVLNode rotateNewRoot(AVLNode root) {
        AVLNode nextRoot = root.left;
        root.left = nextRoot.right;
        nextRoot.right = root;
        //重置平衡度和深度
        root.resetDeptBalance();
        nextRoot.resetDeptBalance();
        return nextRoot;
    }
}
