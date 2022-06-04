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
   
    public int[] diameterOfBinaryTree_(TreeNode root) {
        if(root==null) return new int[]{0,-1};
        
        int[]lr=diameterOfBinaryTree_(root.left);
        int[]rr=diameterOfBinaryTree_(root.right);
        
        int[]myres=new int[2]; //{d,h}
        myres[0]=Math.max(Math.max(lr[0],rr[0]),lr[1]+rr[1]+2);
        myres[1]=Math.max(lr[1],rr[1])+1;
        return myres;
    
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[]dh=new int[2];
        
           dh= diameterOfBinaryTree_(root);
        return dh[0];
    
    }
}