package com.lettcode.jqn.algorthim.tree;

public abstract class AbstractSortTree<T extends AbstractNode<T>> {

    protected T root;

    public abstract boolean insert(int data);

    public T find(int data) {
        T targetNode = root;
        while (targetNode != null && targetNode.getData() != data) {
            if (targetNode.getData() > data) {
                targetNode = targetNode.getLeft();
            } else {
                targetNode = targetNode.getRight();
            }
        }

        if (targetNode == null) {
            System.out.println("未找到节点:" + data);
        } else {
            System.out.println("以找到节点:" + data);
        }
        return targetNode;
    }

    @Override
    public String toString() {
        return root.print();
    }

    public abstract boolean delete(int data);

}
