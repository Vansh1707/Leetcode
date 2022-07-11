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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>ans=new ArrayList<>();
      if(root==null) return ans;
      
      LinkedList<TreeNode>q=new LinkedList<>();
      q.addLast(root);
      
      while(q.size()>0){
          int size=q.size();
          ans.add(q.getLast().val);
          while(size-->0){
              TreeNode rn=q.removeFirst();
              if(rn.left!=null) q.addLast(rn.left);
              if(rn.right!=null) q.addLast(rn.right);
          }
      }
      return ans;
    }
}