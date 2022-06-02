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
    public static TreeNode buildTree(int[] pre,int presi,int preei,int[] post,int postsi,int postei){
        if(presi>preei) return null;
        
        TreeNode root=new TreeNode(pre[presi]);
        if(presi==preei) return root;
        
        int idx=postsi;
        while(post[idx]!=pre[presi+1])
            idx++;
        
        int numofele=idx-postsi+1;
        
        
        root.left=buildTree(pre,presi+1,presi+numofele,post,postsi,postsi+numofele-1);
        root.right=buildTree(pre,presi+numofele+1,preei,post,postsi+numofele,postei-1);
        
        return root;
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int presi=0,preei=pre.length-1;
        int postsi=0,postei=post.length-1;
        
        
        return buildTree(pre,presi,preei,post,postsi,postei);
    }
}