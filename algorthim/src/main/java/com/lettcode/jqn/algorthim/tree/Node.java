package com.lettcode.jqn.algorthim.tree;

public class Node implements AbstractNode<Node> {
    public int data;
    public Node right;
    public Node left;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public int getData() {
        return data;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }
}
