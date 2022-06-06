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
    //{with rob,without rob}
    public int[] rob_(TreeNode root) {
        if (root==null) return new int[]{0,0};
        
        int[]lr=rob_(root.left);
        int[]rr=rob_(root.right);
        
        int[]ans=new int[2];
        ans[0]=lr[1]+root.val+rr[1];
        ans[1]=Math.max(lr[0],lr[1])+Math.max(rr[0],rr[1]);
        
        return ans;
    }
    
    public int rob(TreeNode root) {
        if(root==null)return 0;
        
        int[]ans=rob_(root);
        return Math.max(ans[1],ans[0]);
    }
}