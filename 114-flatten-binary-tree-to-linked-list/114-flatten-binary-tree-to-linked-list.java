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
    public void flatten(TreeNode root) {
        if(root==null)return;
        
        TreeNode templeft=root.left;
        TreeNode tempright=root.right;
        
        root.left=null;
        
        flatten(templeft);
        flatten(tempright);
        
        root.right=templeft;
        TreeNode curr=root;
        while(curr.right!=null)
            curr=curr.right;
        curr.right=tempright;
    }
}
