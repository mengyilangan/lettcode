package com.lettcode.jqn.algorthim.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {
    private Node root;

    public Node search(int data) {
        Node targetNode = root;
        while (targetNode != null && targetNode.data != data) {
            if (targetNode.data > data) {
                targetNode = targetNode.left;
            } else {
                targetNode = targetNode.right;
            }
        }

        if (targetNode == null) {
            System.out.println("未找到节点:" + data);
        } else {
            System.out.println("以找到节点:" + data);
        }
        return targetNode;
    }

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
        //删除了根节点,怎么转换新的根节点
        if (root.data == data) {
            root = removeNode(root);
            return true;
        } else if (root.data < data) {
            return deleteRight(root, data);
        } else {
            return deleteLeft(root, data);
        }

    }

    private boolean deleteRight(Node parent, int data) {
        Node current = parent.right;
        if (current == null) {
            return false;
        } else if (current.data == data) {
            parent.right = removeNode(current);
            return true;
        } else if (current.data < data) {
            return deleteRight(current, data);
        } else {
            return deleteLeft(current, data);
        }
    }

    private boolean deleteLeft(Node parent, int data) {
        Node current = parent.left;
        if (current == null) {
            return false;
        } else if (current.data == data) {
            parent.left = removeNode(current);
            return true;
        } else if (current.data < data) {
            return deleteRight(current, data);
        } else {
            return deleteLeft(current, data);
        }
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

    @Override
    public String toString() {
        return toString(root);
    }

    public String toString(Node root) {
        StringBuilder builder = new StringBuilder();
        append(root, builder);
        return builder.toString();
    }


    public void append(Node node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        append(node.left, builder);
        builder.append(node.data).append(",");
        append(node.right, builder);
    }

    public enum ChildStatus {
        NO,
        LEFT,
        RIGHT,
        ALL,
        ;
    }
}
