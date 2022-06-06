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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->{
           return a.val-b.val; 
        });
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        
        while(pq.size()>0){
            ListNode rn=pq.remove();
            prev.next=rn;
            prev=prev.next;
            
            if(rn.next!=null)
                pq.add(rn.next);
        }
        return dummy.next;
    }
}