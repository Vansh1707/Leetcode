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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        
        ListNode curr=head;
               
        ListNode small=new ListNode(-1);
        ListNode ps=small;
        ListNode large=new ListNode(-1);
        ListNode pl=large;
        
              
        
        while(curr!=null){
            
            if(curr.val<x){
                ps.next=curr;
                ps=ps.next;
            }else{
                pl.next=curr;
                pl=pl.next;
            }
            curr=curr.next;
            
        }
        
        pl.next=null;
        ps.next=large.next;
        
        return small.next;
    }
}