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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode>q=new LinkedList<>();
        q.addLast(root);
        
        
        
        int level=0;
        while(q.size()>0){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            while(size-->0){
                TreeNode rn=q.removeFirst();
                if(level%2==0){
                    if(rn.val%2!=0 && rn.val>max){
                        max=rn.val;
                    }else{
                        return false;
                    }              
                }else{
                    if(rn.val%2==0 && rn.val<min){
                        min=rn.val;
                    }else{
                        return false;  
                    }
                }
                
                if(rn.left!=null)q.addLast(rn.left);
                if(rn.right!=null)q.addLast(rn.right);
            }
            level++;
        }
        return true;
    }
}