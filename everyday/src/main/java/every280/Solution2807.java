package every280;

import bean.ListNode;

/**
 * @author mylg
 * @date 6/1/24
 */
public class Solution2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            ListNode next = current.next;
            int value = computeMaxValue(current.val, next.val);
            current.next = new ListNode(value, next);
            current      = next;
        }
        return head;
    }

    //计算两个数的最大公约数
    public int computeMaxValue(int a, int b) {

        int max = a;
        int min = b;
        if (a < b) {
            max = b;
            min = a;
        }

        int res;
        while ((res = max % min) != 0) {
            max = min;
            min = res;
        }
        return min;
    }
}
