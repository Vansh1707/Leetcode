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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        
        ListNode fast=dummy;
        ListNode slow=dummy;
        
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;            
        }
        ListNode del=slow.next;
        
        slow.next=slow.next.next;
        del.next=null;
        return dummy.next;
    }
}