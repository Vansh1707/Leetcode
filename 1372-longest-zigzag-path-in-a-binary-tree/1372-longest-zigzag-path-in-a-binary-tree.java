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
    //{forwslop,backslop,longestzigzagpath}
    public int[] longestZigZag_(TreeNode root) {
        if(root==null) return new int[]{-1,-1,-1};
        
        int[]lr=longestZigZag_(root.left);
        int[]rr=longestZigZag_(root.right);
        
        int[]ans=new int[3];
        ans[0]=lr[1]+1;
        ans[1]=rr[0]+1;
        ans[2]=Math.max(Math.max(ans[0],ans[1]),Math.max(lr[2],rr[2]));
        
        return ans;
    }
    
    public int longestZigZag(TreeNode root) {
        return longestZigZag_(root)[2];
    }
}