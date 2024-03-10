package com.lettcode.jqn.algorthim.find;

import java.util.concurrent.ThreadLocalRandom;

//为什么需要tail指针呢?
public class SkipList {
    private SkipNode head, tail;

    private int maxLevel;

    public SkipList() {
        this.head = new SkipNode(Integer.MIN_VALUE);
        this.tail = new SkipNode(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
    }


    public SkipNode search(int data) {
        SkipNode pre = searchPre(data);
        if (pre.data == data) {
            return pre;
        } else {
            return null;
        }
    }

    /**
     * 上层节点一定有向下的
     *
     * @param data
     * @return
     */
    private SkipNode searchPre(int data) {
        SkipNode point = head;
        while (true) {
            while (point.next.data <= data) {
                point = point.next;
            }

            if (point.lower == null) {
                return point;
            }
            point = point.lower;
        }
    }

    /**
     * 下层节点不一定都有向上的吧
     *
     * @param data
     * @return
     */
    public boolean insert(int data) {
        SkipNode litterIndex = searchPre(data);
        if (litterIndex.data == data) {
            System.out.println("已经插入无需再次插入");
            return false;
        }

        //第一次插入不用管
        SkipNode lowest = insertPre(litterIndex, data);
        if (maxLevel == 0) {
            maxLevel = 1;
            return true;
        }

        //考虑是否向上晋升
        ThreadLocalRandom random = ThreadLocalRandom.current();
        //如何知道上一个节点是谁呢？
        int level = 2;
        boolean append;
        while ((append = random.nextBoolean()) && level <= maxLevel) {
            while (litterIndex.upper == null) {
                litterIndex = litterIndex.pre;
            }
            litterIndex = litterIndex.upper;
            SkipNode current = insertPre(litterIndex, data);
            current.lower = lowest;
            lowest.upper = current;
            lowest = current;
            level += 1;
        }
        //是否超越顶级
        if (append && random.nextBoolean()) {
            SkipNode insert = addTop(data);
            insert.lower = lowest;
            lowest.upper = insert;
        }
        return true;
    }

    private SkipNode insertPre(SkipNode litterIndex, int data) {
        SkipNode insertData = new SkipNode(data);
        insertData.next = litterIndex.next;
        insertData.pre = litterIndex;
        litterIndex.next.pre = insertData;
        litterIndex.next = insertData;
        return insertData;
    }


    private SkipNode addTop(int data) {
        SkipNode head = new SkipNode(Integer.MIN_VALUE);
        head.lower = this.head;
        this.head.upper = head;
        this.head = head;

        SkipNode tail = new SkipNode(Integer.MAX_VALUE);
        tail.lower = this.tail;
        this.tail.upper = tail;
        this.tail = tail;

        this.head.next = this.tail;
        this.tail.pre = this.head;

        maxLevel += 1;
        return insertPre(this.head, data);
    }


    public boolean delete(int data) {
        SkipNode point = head;

        do {
            while (point.next.data <= data) {
                point = point.next;
            }
            if (point.data == data) {
                deleteToEnd(point);
                return true;
            }
            point = point.lower;
        } while (point != null);
        return false;
    }


    private void deleteToEnd(SkipNode point) {
        do {
            point.pre.next = point.next;
            point.next.pre = point.pre;
            if (point.pre.pre == null && point.next.next == null) {
                maxLevel -= 1;
            }
            point = point.lower;
        } while (point != null);
    }

    public void printList() {
        SkipNode head = this.head;
        while (head != null) {
            SkipNode point = head.next;
            StringBuilder builder = new StringBuilder();
            while (point.next != null) {
                if (point.lower != null) {
                    builder.append('[').append(point.data).append(']').append(',');
                } else {
                    builder.append(point.data).append(',');
                }
                point = point.next;
            }
            System.out.println(builder);
            head = head.lower;
        }

    }


}
