/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
         if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1), prev = dummy, curr = head;
        prev.next = curr;
        while (curr != null) {
            boolean isLoopRun = false;
            while (curr.next != null && prev.next.val == curr.next.val) {
                curr = curr.next;
                isLoopRun = true;
            }
            if (!isLoopRun)
                prev = prev.next;
            prev.next = curr.next;
            
            curr = curr.next;
        }

        return dummy.next;
    }
}