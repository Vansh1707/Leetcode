/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class pair{
        TreeNode node=null;
        int idx=0;
        
        pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int maxwidth=0;
        LinkedList<pair>q=new LinkedList<>();
        q.addLast(new pair(root,0));
        
        while(q.size()>0){
            int size=q.size();
            int lm=q.getFirst().idx;
            int rm=q.getFirst().idx;
            while(size-->0){
                pair rp=q.removeFirst();
                rm=rp.idx; // right idx update
                
                if(rp.node.left!=null) q.addLast(new pair(rp.node.left,rp.idx*2+1));
                if(rp.node.right!=null) q.addLast(new pair(rp.node.right,rp.idx*2+2));
            }
            maxwidth=Math.max(maxwidth,rm-lm+1);
        }
        return maxwidth;
    }
}