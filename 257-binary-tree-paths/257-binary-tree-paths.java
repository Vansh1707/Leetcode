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
    private void dfs(TreeNode root,String psf,List<String>ans){
        psf+="->"+root.val;
        
        if(root.left==null && root.right==null){
            ans.add(psf);
            return;
        }
        if(root.left!=null)dfs(root.left,psf,ans);
        if(root.right!=null)dfs(root.right,psf,ans);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans=new ArrayList<>();
        if(root==null)return ans;
        
        String psf=root.val+"";
        if(root.left==null && root.right==null)ans.add(psf);
        if(root.left!=null)dfs(root.left,psf,ans);
        if(root.right!=null)dfs(root.right,psf,ans);
        
        return ans;
    }
}