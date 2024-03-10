package com.lettcode.jqn.algorthim.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree extends AbstractSortTree<Node> {
    @Override
    public boolean insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return true;
        }

        Node targetNode = root;
        while (true) {
            if (data == targetNode.data) {
                System.out.println("二叉查找树中已有重复的节点：" + data);
                return false;
            } else if (data > targetNode.data) {
                if (targetNode.right == null) {
                    targetNode.right = node;
                    return true;
                }
                targetNode = targetNode.right;
            } else {
                if (targetNode.left == null) {
                    targetNode.left = node;
                    return true;
                }
                targetNode = targetNode.left;
            }
        }
    }

    public boolean delete(int data) {
        OperateRes res = deleteNode(root, data);
        if (res == null) {
            return false;
        } else if (res.currentRes) {
            root = removeNode(root);
        }
        return res.finalRes;

    }


    public OperateRes deleteNode(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            return OperateRes.currentOperate();
        }

        OperateRes res;
        if (node.data > data) {
            res = deleteNode(node.left, data);
            if (res != null) {
                if (res.currentRes) {
                    node.left = removeNode(node.left);
                    res.childOperate();
                }
            }
        } else {
            res = deleteNode(node.right, data);
            if (res != null) {
                if (res.currentRes) {
                    node.right = removeNode(node.right);
                    res.childOperate();
                }
            }
        }
        return res;
    }

    //从移除节点的子节点找一个新的根节点
    private Node removeNode(Node node) {
        Node root = null;
        ChildStatus childStatus = queryChildStatus(node);
        switch (childStatus) {
            case LEFT:
                root = node.left;
                break;
            case RIGHT:
                root = node.right;
                break;
            case ALL:
                //查找一个稍大一点的值
                Node nextRoot = node.right;
                //把和上级的联系断掉
                Node before = node;
                while (nextRoot.left != null) {
                    before = nextRoot;
                    nextRoot = nextRoot.left;
                }
                before.left = null;
                nextRoot.left = node.left;

                Node temp = node.right;
                root = nextRoot;
                Node findLarge = nextRoot;
                while (findLarge.right != null) {
                    findLarge = findLarge.right;
                }
                findLarge.right = temp;
                break;
            default:
                break;
        }
        return root;
    }

    private ChildStatus queryChildStatus(Node parent) {
        if (parent.left == null) {
            if (parent.right == null) {
                return ChildStatus.NO;
            } else {
                return ChildStatus.RIGHT;
            }
        } else if (parent.right == null) {
            return ChildStatus.LEFT;
        } else {
            return ChildStatus.ALL;
        }
    }


    public enum ChildStatus {
        NO,
        LEFT,
        RIGHT,
        ALL,
        ;
    }
}
