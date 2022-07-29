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
    ArrayList<Integer>ans;
    public TreeNode getrightMostNode(TreeNode node,TreeNode curr){
      while(node.right!=null && node.right!=curr){
          node=node.right;
      }
      return node;
  }

  public void morrisPreTraversal(TreeNode root) {
    ans=new ArrayList<>();
    TreeNode curr=root;
    while(curr!=null){
         
        TreeNode left=curr.left;
        if(left==null){
            ans.add(curr.val);
            curr=curr.right;
        }else{
            TreeNode rightMostNode=getrightMostNode(left,curr);
            if(rightMostNode.right==null){
                rightMostNode.right=curr;//thread created
                curr=curr.left;
            }else{
                rightMostNode.right=null;//thread cut
                ans.add(curr.val);
                curr=curr.right;
            }
        }
    }
  }
    public boolean findTarget(TreeNode root, int k) {
        morrisPreTraversal(root);
        int i=0,j=ans.size()-1;
        while(i<j){
            if(ans.get(i)+ans.get(j)==k)return true;
            else if(ans.get(i)+ans.get(j)<k)i++;
            else j--;
        }
        return false;
    }
}