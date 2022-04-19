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
    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }

        return node;
    }
    
    public void recoverTree(TreeNode root) {
        TreeNode curr=root;
        TreeNode prev=null,a=null,b=null;
        
        while(curr!=null){
            TreeNode left=curr.left;
            if(left==null){
                if(prev!=null && prev.val>curr.val){
                    if(a==null)
                        a=prev;
                    b=curr;
                }
                prev=curr;
                curr=curr.right;
            }else{
                TreeNode rightMostNode=getRightMostNode(left,curr);
                if(rightMostNode.right==null){
                    rightMostNode.right=curr;
                    curr=curr.left;
                }else{
                    rightMostNode.right=null;
                    
                    if(prev!=null && prev.val>curr.val){
                        if(a==null) 
                            a=prev;
                        b=curr;
                    }
                    prev=curr;
                    curr=curr.right;
                }
            }
        }
        
        if(a!=null){
            int temp=a.val;
            a.val=b.val;
            b.val=temp;
        }
    }
}