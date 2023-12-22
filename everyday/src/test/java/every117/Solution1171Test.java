package every117;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1171Test {

    @Test
    void removeZeroSumSublists() {
        Solution1171 solution = new Solution1171();
        ListNode first = new ListNode(1);
        ListNode end = new ListNode(-1);
        first.next = end;
        ListNode head = solution.removeZeroSumSublists(first);
        System.out.println(head);
    }

    @Test
    void removeZeroSumSublistsCase1() {
        Solution1171 solution = new Solution1171();
        ListNode first = new ListNode(0);
        ListNode head = solution.removeZeroSumSublists(first);
        System.out.println(head);
    }
}