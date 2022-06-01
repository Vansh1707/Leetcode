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
    public static TreeNode constructFromInOrder(int[] inOrder,int si,int ei) {
        if(si>ei) return null;
        
        int mid=(si+ei)/2;
        TreeNode root=new TreeNode(inOrder[mid]);
        
        root.left=constructFromInOrder(inOrder,si,mid-1);
        root.right=constructFromInOrder(inOrder,mid+1,ei);
        
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructFromInOrder(nums,0,nums.length-1);
    }
}