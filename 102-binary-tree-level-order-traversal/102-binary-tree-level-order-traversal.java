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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        
        LinkedList<TreeNode>q=new LinkedList<>();
        q.addLast(root);
        
        while(q.size()>0){
            int size=q.size();
            List<Integer>lev=new ArrayList<>();
            while(size-->0){
                TreeNode rn=q.removeFirst();
                lev.add(rn.val);
                if(rn.left!=null){//add child to queue
                    q.addLast(rn.left);
                }
                if(rn.right!=null){
                    q.addLast(rn.right);
                }
            }
            ans.add(lev);
        }
        return ans;
    }
}