/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
      public void printkdown(TreeNode root, TreeNode Block, int k, List<Integer> ans){
        if(root==null||root==Block||k<0)return;
          if(k==0){
              ans.add(root.val);
          }
          printkdown(root.left,Block,k-1,ans);
          printkdown(root.right,Block,k-1,ans);
        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer>ans=new ArrayList<>();
        roottonodedist(root,target.val,ans,K);
        return ans;
    }
    
    public int roottonodedist(TreeNode root, int data, List<Integer> ans, int k ){
       if(root==null)return -1;
        if(root.val==data){
            TreeNode Block=null;
            printkdown(root,Block,k,ans);
            return 1;
        }
        int lans=roottonodedist(root.left,data,ans,k);
        if(lans!=-1){
            TreeNode Block=root.left;
            printkdown(root,Block,k-lans,ans);
            return lans+1;
        }
        int rans=roottonodedist(root.right,data,ans,k);
        if(rans!=-1){
            TreeNode Block=root.right;
            printkdown(root,Block,k-rans,ans);
            return rans+1;
        }
        return -1;
    }

}
