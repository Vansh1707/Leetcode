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
    TreeNode pre = null;

public void flatten(TreeNode root) {
    
    if(root == null){
        return;
    }
    
    flatten(root.right); //we will try to reach to the right most node first
    flatten(root.left);
    
    root.right = pre; //After reaching to right most node connect it to the pre node
    root.left = null; // make left node null simultaneously
    pre = root;       //make sure to update the pre node to root
}
}