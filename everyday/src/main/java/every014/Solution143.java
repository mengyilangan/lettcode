package every014;

/**
 * https://leetcode.cn/problems/reorder-list/?envType=daily-question&envId=2023-11-24
 */

public class Solution143 {
    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * <p>
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 链表的长度范围为 [1, 5 * 104]
     * 1 <= node.val <= 1000
     *
     * @param head
     */
    public ListNode buildNode(int[] ints) {
        ListNode head = new ListNode();
        head.val = ints[0];
        ListNode before = head;
        for (int i = 1; i < ints.length; i++) {
            ListNode node = new ListNode();
            node.val = ints[i];
            before.next = node;
            before = node;
        }
        return head;
    }


    public void reorderList(ListNode head) {
        //一个或者两个节点都不需要管
        if (head.next == null || head.next.next == null) {
            return;
        }

        //中间这个指针要置空,不要引用过来
        ListNode pre = head.next.next;
        ListNode suf = head;
        while (pre != null && pre.next != null) {
            suf = suf.next;
            pre = pre.next.next;
        }

        //和后半段断开
        ListNode left = suf.next;
        suf.next = null;
        suf = left;

        //后半段链表反转
        ListNode reverse = null;
        //链表反转过来了
        while (suf != null) {
            ListNode temp = suf.next;
            suf.next = reverse;
            reverse = suf;
            suf = temp;
        }

        ListNode total = head;
        head = head.next;

        //两个链表逐次合并
        while (reverse != null && head != null) {
            ListNode l1 = head.next;
            ListNode l2 = reverse.next;
            //依次赋值
            total.next = reverse;
            total = total.next;
            total.next = head;
            total = total.next;
            //head 和reverse后移
            head = l1;
            reverse = l2;
        }

        if (reverse != null) {
            total.next = reverse;
            total = total.next;
        }

        if (head != null) {
            total.next = head;
        }
    }

    public void print(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append(",");
            node = node.next;
        }
        System.out.println(builder.toString());
    }
}


