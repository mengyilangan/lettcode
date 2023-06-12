package every117;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * <p>
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 */
public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null ) {
            return head;
        }
        boolean end = true;
        while (end) {
            ListNode p = head;
            int sum = 0;
            Set<Integer> has = new HashSet<>();
            while (p != null) {
                sum += p.val;
                //存在相等的值
                if (sum == 0) {
                    //从头删除到现在
                    head = p.next;
                } else if (!has.add(sum)) {
                    deleteNode(head, sum);
                    break;
                }
                p = p.next;
            }
            if (p == null) {
                end = false;
            }
        }
        return head;
    }

    private void deleteNode(ListNode head, int target) {
        int sum = 0;
        ListNode p = head;
        while (p != null) {
            sum += p.val;
            //存在相等的值
            if (sum == target) {
                break;
            }
            p = p.next;
        }
        ListNode deleteNode = p.next;

        while (deleteNode != null) {
            sum += deleteNode.val;
            if (sum == target) {
                p.next = deleteNode.next;
                break;
            }
            deleteNode = deleteNode.next;
        }
    }
}
