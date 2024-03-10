package com.lettcode.jqn.algorthim.tree.redblack;

import com.lettcode.jqn.algorthim.tree.AbstractNode;

public class RedBlackNode implements AbstractNode<RedBlackNode> {
    public int data;

    public RedBlackNode left;

    public RedBlackNode right;

    public Color color;

    public RedBlackNode(int data) {
        this.data = data;
        this.color = Color.RED;
    }

    public void reverseColor() {
        switch (color) {
            case RED:
                this.color = Color.BLACK;
                break;
            case BLACK:
                this.color = Color.RED;
                break;
        }
    }

    @Override
    public int getData() {
        return data;
    }

    @Override
    public RedBlackNode getLeft() {
        return left;
    }

    @Override
    public RedBlackNode getRight() {
        return right;
    }
}
