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
    int max = 0,sum=0;
    void rec(TreeNode root,int level){
        if(root.left!=null) rec(root.left,level+1);
        else if(root.right==null){
            if(max<level){
                sum=0;
                sum+=root.val;
                max=level;
            }
            else if(max==level) sum+=root.val;
        }
        if(root.right!=null) rec(root.right,level+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        rec(root,0);
        return sum;
    }
}