package every248;

import bean.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author mylg
 * @date 3/1/24
 */
public class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        Deque<ListNode> queue = new ArrayDeque<>(2);
        queue.push(head);
        ListNode p = head.next;
        while (p != null) {
            ListNode max = queue.peekFirst();
            if (p.val > max.val) {
                //当前节点是最大节点,历史节点直接全部清空,从该节点开始
                queue.clear();
                queue.push(p);
                p = p.next;
                continue;
            }
            ListNode recent;
            do {
                recent = queue.pollLast();
            } while (recent != null && p.val > recent.val);

            if (recent == null) {
                queue.add(p);
                p = p.next;
                continue;
            }
            recent.next = p;
            queue.add(recent);
            queue.add(p);
            p = p.next;
        }
        return queue.getFirst();
    }
}
