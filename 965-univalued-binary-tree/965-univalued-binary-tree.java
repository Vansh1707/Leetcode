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
    public boolean isUnivalTree_(TreeNode root,int value) {
        if(root==null)return true;
        
        
        if(root.val!=value) return false;

        
        return isUnivalTree_(root.left,value) && isUnivalTree_(root.right,value);
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)return true;
        
        return isUnivalTree_(root,root.val);
    }
}