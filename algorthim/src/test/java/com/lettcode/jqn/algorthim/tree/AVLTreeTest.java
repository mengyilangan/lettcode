package com.lettcode.jqn.algorthim.tree;

import com.lettcode.jqn.algorthim.tree.avl.AVLTree;
import org.junit.jupiter.api.Test;

class AVLTreeTest {
    @Test
    public void testCase1() {
        AVLTree avlTree = new AVLTree();
        int[] arr = {5, 4, 7, 2, 6, 9, 1,3};
        for (int v : arr) {
            avlTree.insert(v);
        }
        System.out.println(avlTree);
    }
}