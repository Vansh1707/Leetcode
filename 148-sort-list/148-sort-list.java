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
    public static ListNode midNode(ListNode head) {
    
        if(head==null || head.next==null) return head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null)return l1!=null ? l1:l2;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode c1=l1,c2=l2;
        
        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                prev.next=c1;
                c1=c1.next;
            }else{
                prev.next=c2;
                c2=c2.next;
            }
            prev=prev.next;
        }
        prev.next=c1!=null ? c1:c2;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode mid=midNode(head);
        ListNode newhead=mid.next;
        mid.next=null;
        
        ListNode l1=sortList(head);
        ListNode l2=sortList(newhead);
        return mergeTwoLists(l1,l2);
        
    }
}