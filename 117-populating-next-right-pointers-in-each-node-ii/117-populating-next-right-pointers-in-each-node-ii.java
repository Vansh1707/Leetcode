/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)return null;
        LinkedList<Node>q=new LinkedList<>();
        q.add(root);
        
        while(q.size()>0){
            int size=q.size();
            Node prev=null;
            while(size-->0){
                Node rn=q.removeFirst();
                if(prev==null)prev=rn;
                else prev=prev.next=rn;
                    
                if(rn.left!=null){//add child to queue
                    q.addLast(rn.left);
                }
                if(rn.right!=null){
                    q.addLast(rn.right);
                }
            }
        }
        return root;
        
    }
}