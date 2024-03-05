package com.lettcode.jqn.algorthim.tree.redblack;

import com.lettcode.jqn.algorthim.tree.AbstractSortTree;

import java.util.Stack;

/**
 * 也是一个二叉查找树
 * 1.节点是红色或者黑色
 * 2.根节点是黑色的
 * 3.每个叶子节点都是黑色的空节点
 * 4.每个红色节点的子节点都是黑色(即不存在两个连续的红色节点)
 * 6.新插入节点默认是红色的
 * 全黑不就行了？
 */
public class RedBlackTree extends AbstractSortTree<RedBlackNode> {

    @Override
    public boolean insert(int data) {
        Stack<RedBlackNode> parents = new Stack<>();
        return insert(root, data, parents);
    }

    public void link(RedBlackNode parent, RedBlackNode son) {
        if (parent == null) {
            root = son;
            root.color = Color.BLACK;
        } else if (parent.data > son.data) {
            parent.left = son;
        } else {
            parent.right = son;
        }
    }

    //1.不平衡只是这一个,还是都会不平衡
    public boolean insert(RedBlackNode current, int data, Stack<RedBlackNode> parents) {
        if (current == null) {
            RedBlackNode insert = new RedBlackNode(data);
            RedBlackNode parent = parents.pop();
            link(parent, insert);
            if (parent == null || parent.color == Color.BLACK) {
                return true;
            }

            //查看祖父
            RedBlackNode grand = parents.pop();

            //爹和叔叔都是红色
            if (grand.left != null && grand.right != null && grand.left.color == grand.right.color) {
                //满足选项2,插入节点
            }

            //判断关系到底是左右还是右左[不平衡]

            return false;
        }

        if (current.data == data) {
            System.out.println("已经插入无需再次插入,data=" + data);
            return false;
        }

        //是否因为历史调整而导致父节点的不公平
        parents.push(current);
        boolean res;
        if (current.data > data) {
            res = insert(current.left, data, parents);
        } else {
            res = insert(current.right, data, parents);
        }
        return res;
    }


    @Override
    public boolean delete(int data) {
        return false;
    }
}
