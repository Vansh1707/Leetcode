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
    public TreeNode getRightMostNode(TreeNode node,TreeNode curr){
      while(node.right!=null && node.right!=curr){
          node=node.right;
      }
      return node;
  }
    public int kthSmallest(TreeNode root, int k) {
        int rv=-1;
        TreeNode curr=root;
        while(curr!=null){
            TreeNode left=curr.left;
            if(left==null){
                if(--k == 0) rv=curr.val;
                curr=curr.right;
            }else{
                TreeNode rightMostNode=getRightMostNode(left,curr);
                if(rightMostNode.right==null){
                    rightMostNode.right=curr;//thread created
                    curr=curr.left;
                }else{
                    rightMostNode.right=null;//thread cut
                    if(--k == 0) rv=curr.val;
                    curr=curr.right;
                }
            }
        }
        return rv;
    }
}