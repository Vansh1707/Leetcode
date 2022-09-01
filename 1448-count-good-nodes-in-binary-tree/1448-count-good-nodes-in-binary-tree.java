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
    private int goodNodesHelper(TreeNode root, int previous) {
        if (root == null) return 0;
        int nodes = 0;
        if (root.val >= previous) nodes ++;
        
        return goodNodesHelper(root.left, Math.max(root.val, previous)) + 
			   goodNodesHelper(root.right, Math.max(root.val, previous)) + nodes;
    }
    
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, Integer.MIN_VALUE);
    }
    
}