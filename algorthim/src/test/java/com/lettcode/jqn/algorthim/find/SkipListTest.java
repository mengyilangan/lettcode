package com.lettcode.jqn.algorthim.find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipListTest {

    @Test
    public void case1() {
        SkipList skipList = new SkipList();
        int[] arr = {50, 15, 13, 20, 100, 75, 99, 76, 83, 65};
        for (int a : arr) {
            skipList.insert(a);
        }
        skipList.printList();
        SkipNode node = skipList.search(50);
        Assertions.assertNotNull(node);
        Assertions.assertEquals(50, node.data);
        Assertions.assertNotNull(node.pre);
        Assertions.assertEquals(20, node.pre.data);
        Assertions.assertNotNull(node.next);
        Assertions.assertEquals(65, node.next.data);
        boolean value = skipList.delete(50);
        Assertions.assertTrue(value);
        System.out.println("——------------------------------");
        skipList.printList();

        node = skipList.search(50);
        Assertions.assertNull(node);
    }

}