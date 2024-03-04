package com.lettcode.jqn.algorthim.tree;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    public void testCase1() {
        BinarySearchTree findTree = new BinarySearchTree();
        int[] arr = {6, 3, 8, 2, 4, 7, 9, 1, 5};
        for (int v : arr) {
            findTree.insert(v);
        }
        System.out.println(findTree);
    }

    @Test
    public void testCase2() {
        BinarySearchTree findTree = new BinarySearchTree();
        int[] arr = {9, 5, 13, 2, 7, 11, 1, 3, 6, 8, 10, 12};
        for (int v : arr) {
            findTree.insert(v);
        }
        System.out.println(findTree);
    }

    @Test
    public void testCase3() {
        BinarySearchTree findTree = new BinarySearchTree();
        int[] arr = {9, 5, 13, 2, 7, 11, 1, 3, 6, 8, 10, 12};
        for (int v : arr) {
            findTree.insert(v);
        }
        System.out.println(findTree);
        findTree.delete(12);
        System.out.println(findTree);
    }

    @Test
    public void testCase4() {
        BinarySearchTree findTree = new BinarySearchTree();
        int[] arr = {9, 5, 13, 2, 7, 11, 1, 3, 6, 8, 10, 12};
        for (int v : arr) {
            findTree.insert(v);
        }
        System.out.println(findTree);
        findTree.delete(13);
        System.out.println(findTree);
    }

    @Test
    public void testCase5() {
        BinarySearchTree findTree = new BinarySearchTree();
        int[] arr = {9, 5, 13, 2, 7, 11, 1, 3, 6, 8, 10, 12};
        for (int v : arr) {
            findTree.insert(v);
        }
        System.out.println(findTree);
        findTree.delete(5);
        System.out.println(findTree);
    }

    @Test
    public void testCase6() {
        BinarySearchTree findTree = new BinarySearchTree();
        int[] arr = {9, 5, 13, 2, 7, 11, 1, 3, 6, 8, 10, 12};
        for (int v : arr) {
            findTree.insert(v);
        }
        System.out.println(findTree);
        findTree.delete(9);
        System.out.println(findTree);
    }

}