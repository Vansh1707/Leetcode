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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null)return head;
        ListNode curr=head;
        ListNode prev=null;
        
        while(m>1){
            prev=curr;
            curr=curr.next;
            m--;
            n--;
        }
        ListNode nhead=prev;
        ListNode tail=curr;
        
        while(n>0){
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
            n--;
        }
        if(nhead!=null)nhead.next=prev;
        else head=prev;
        
        tail.next=curr;
        
        return head;
    }
}