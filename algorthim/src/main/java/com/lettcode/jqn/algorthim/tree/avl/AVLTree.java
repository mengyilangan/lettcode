package com.lettcode.jqn.algorthim.tree.avl;

import com.lettcode.jqn.algorthim.tree.AbstractSortTree;

//对于每一个节点左子树高度和右子数高度的差值绝对值<=1,维护绝对平衡
public class AVLTree extends AbstractSortTree<AVLNode> {

    public boolean insert(int data) {
        if (root == null) {
            root = new AVLNode(data);
            return true;
        }
        return insert(root, data);
    }


    /**
     * 可以再简化一下
     *
     * @param root
     * @param data
     * @return
     */
    private boolean insert(AVLNode root, int data) {
        if (root.data == data) {
            System.out.println("数据已经插入,data=" + data);
            return false;
        }

        if (root.data > data) {
            if (root.left == null) {
                root.left = new AVLNode(data);
                root.resetDeptBalance();
                return true;
            } else {
                boolean res = insert(root.left, data);
                if (res) {
                    //todo:看看左子树是否平衡,不平衡就整平衡
                    root.left = balanceNode(root.left);
                    root.resetDeptBalance();
                }
                return res;
            }
        } else {
            if (root.right == null) {
                root.right = new AVLNode(data);
                root.resetDeptBalance();
                return true;
            } else {
                boolean res = insert(root.right, data);
                if (res) {
                    //todo:看看右子树是否平衡,不平衡就整平衡
                    root.right = balanceNode(root.right);
                    root.resetDeptBalance();
                }
                return res;
            }

        }
    }

    private AVLNode balanceNode(AVLNode node) {
        if (Math.abs(node.balance) <= 1) {
            return node;
        }

        Rotate rotate = null;
        if (node.balance > 1) {
            if (node.left.balance > 0) {
                rotate = new LLRotate();
            } else if (node.left.balance < 0) {
                rotate = new LRRotate();
            }
        } else {
            if (node.right.balance > 0) {
                rotate = new RLRotate();
            } else if (node.right.balance < 0) {
                rotate = new RRRotate();
            }
        }

        return rotate.rotateNewRoot(node);
    }

    //w
    @Override
    public boolean delete(int data) {
        //经历二叉查找树的删除,同时还需要rebalance

        return false;
    }


}
