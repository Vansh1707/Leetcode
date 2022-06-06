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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode dummyeven=new ListNode(-1);
        ListNode dummyodd=new ListNode(-1);
        ListNode eventail=dummyeven,oddtail=dummyodd,curr=head;
        int oddeve=1;
        while(curr!=null){
            if(oddeve%2!=0){
                oddtail.next=curr;
                oddtail=oddtail.next;
            }else{
                eventail.next=curr;
                eventail=eventail.next;
            }
            oddeve++;
            curr=curr.next;
        }
        oddtail.next=dummyeven.next;
        eventail.next=null;
        return dummyodd.next;
    }
}