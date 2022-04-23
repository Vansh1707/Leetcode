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
    TreeNode prev=null;
    int min=(int)1e9;
    public int minDiffInBST(TreeNode root) {
        if(root==null)return 0;
        
        minDiffInBST(root.left);
        
        if(prev!=null) min=Math.min(min,root.val-prev.val);
        prev=root;
        
        minDiffInBST(root.right);
        
        return min;
    }
}