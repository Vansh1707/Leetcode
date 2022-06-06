/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    //FLOYAD CYCLE
    
    public static ListNode CycleNode(ListNode head) {
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
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode tail=headA;
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=headB;
        
        ListNode ans=CycleNode(headA);
        
        tail.next=null;
        return ans;
    }
}