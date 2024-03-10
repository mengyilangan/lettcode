package bean;

//Definition for singly-linked list.
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val  = val;
        this.next = next;
    }


    public static ListNode build(int[] arr) {
        int last = arr.length - 1;
        ListNode head = null;
        while (last >= 0) {
            head = new ListNode(arr[last], head);
            last--;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}
