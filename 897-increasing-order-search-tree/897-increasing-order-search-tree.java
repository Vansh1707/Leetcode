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
//     ArrayList<TreeNode>list=new ArrayList<>();
//     public void inorder(TreeNode root){
//         if(root==null)return;
        
//         inorder(root.left);
//         list.add(root);
//         inorder(root.right);
//     }
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)return root;
        ArrayList<TreeNode>ans=new ArrayList<>();
        TreeNode curr=root;
      while(curr!=null){
          TreeNode left=curr.left;
          if(left==null){
              ans.add(curr);
              curr=curr.right;
          }else{
              TreeNode rightmostnode=getRightMostNode(left,curr);
              if(rightmostnode.right==null){
                  rightmostnode.right=curr; //thread created
                  curr=curr.left;
              }else{
                  rightmostnode.right=null; // thread cut
                  ans.add(curr);
                  curr=curr.right;
              }
          }
      }
        
        for(int i=0;i<ans.size()-1;i++){
            ans.get(i).right=ans.get(i+1);
            ans.get(i).left=null;
        }
        ans.get(ans.size()-1).left=null;
        ans.get(ans.size()-1).right=null;
        
        return ans.get(0);
    }
}