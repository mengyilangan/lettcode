package com.lettcode.jqn.algorthim.tree.redblack;

import com.lettcode.jqn.algorthim.tree.avl.AVLNode;

/**
 * 祖父节点判定是否平衡
 */
public interface Rotate {
    RedBlackNode rotateNewRoot(RedBlackNode grand);
}
