/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        
        ListNode fast=head,slow=head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(slow==fast) break;
        }
        if(slow!=fast) return null; //not a cycle
        
        slow=head;
        fast=fast;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}