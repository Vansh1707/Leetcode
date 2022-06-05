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
     int cameras=0;
    
    public  int minCameraCover_(TreeNode root) {//helps to check if camera needed
        if(root==null) return 1;  //null dont need and dont have camera
        
        int lchild=minCameraCover_(root.left);
        int rchild=minCameraCover_(root.right);
        
        if(lchild==-1 || rchild==-1){ //if any one child need camera 
            cameras++;//i have to place camera
            return 0;
        }
        if(lchild==0 || rchild==0) return 1;//if any one child has camera
        
        //child dont have and dont need camera
        return -1;
    }
    
    public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        if(minCameraCover_(root)==-1) cameras++; //if need camera
        
        return cameras;
    }
}