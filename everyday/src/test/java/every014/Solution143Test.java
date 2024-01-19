package every014;

import bean.ListNode;
import org.junit.jupiter.api.Test;

class Solution143Test {

    /**
     * 输入：head = [1,2,3,4]
     * 输出：[1,4,2,3]
     * <p>
     * 输入：head = [1,2,3,4,5]
     * 输出：[1,5,2,4,3]
     */
    @Test
    void reorderList() {
        Solution143 solution143 = new Solution143();
        int[] headInts = {1, 2, 3, 4};
        ListNode head = solution143.buildNode(headInts);
        solution143.print(head);
        solution143.reorderList(head);
        solution143.print(head);
    }
}
