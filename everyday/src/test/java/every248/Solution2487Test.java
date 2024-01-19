package every248;

import bean.ListNode;
import every2096.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mylg
 * @date 3/1/24
 */
class Solution2487Test {

    private Solution2487 solution = new Solution2487();

    @Test
    void case1() {
        int[] arr = { 5, 2, 13, 3, 8 };
        ListNode head = ListNode.build(arr);
        System.out.println(solution.removeNodes(head));
    }
}
