package com.lettcode.jqn.algorthim.tree.avl;

import com.lettcode.jqn.algorthim.tree.AbstractNode;

public class AVLNode implements AbstractNode<AVLNode> {
    public int data;
    public AVLNode right;
    public AVLNode left;

    //深度,平衡二叉树需要
    public int dept;

    //深度,平衡二叉树需要
    public int balance;

    public AVLNode(int data) {
        this.data = data;
        this.dept = 1;
        this.balance = 0;
    }

    public void resetDeptBalance() {
        int leftDept = left == null ? 0 : left.dept;
        int rightDept = right == null ? 0 : right.dept;
        this.dept = Math.max(leftDept, rightDept) + 1;
        this.balance = leftDept - rightDept;
    }

    @Override
    public int getData() {
        return data;
    }

    @Override
    public AVLNode getLeft() {
        return left;
    }

    @Override
    public AVLNode getRight() {
        return right;
    }
}
