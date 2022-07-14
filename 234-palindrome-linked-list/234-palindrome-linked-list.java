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
    public static ListNode reverse(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
       
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;
        nhead=reverse(nhead);
        // while(head!=null){
        //     System.out.println(head.val);
        //     head=head.next;
        // }
        ListNode c1=head,c2=nhead;
        boolean res=true;
        while(c2!=null){
            if(c1.val!=c2.val){
                res=false;
                break;
            }
            c1=c1.next;
            c2=c2.next;
            
        }
        return res;
        
    }
}