package com.lettcode.jqn.algorthim.tree;

public interface AbstractNode<T extends AbstractNode> {
    int getData();

    T getLeft();

    T getRight();

    default String print() {
        StringBuilder builder = new StringBuilder();
        T left = getLeft();
        if (left != null) {
            builder.append(left.print()).append(',');
        }

        builder.append(getData());
        T right = getRight();
        if (right != null) {
            builder.append(',').append(right.print());
        }
        return builder.toString();
    }
}
