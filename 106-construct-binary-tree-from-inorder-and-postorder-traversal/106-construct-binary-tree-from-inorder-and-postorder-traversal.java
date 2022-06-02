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
     public static TreeNode buildTree(int[] postorder,int psi,int pei,int[] inorder,int isi,int iei){
        if(psi>pei) return null;
        
        int idx=isi;
        while(inorder[idx]!=postorder[pei]) idx++;
        
        int numofele=idx-isi;
        TreeNode root=new TreeNode(postorder[pei]);
        
        root.left=buildTree(postorder,psi,psi+numofele-1,inorder,isi,idx-1);
        root.right=buildTree(postorder,psi+numofele,pei-1,inorder,idx+1,iei);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int psi=0,pei=postorder.length-1;
        int isi=0,iei=inorder.length-1;
        
        
        return buildTree(postorder,psi,pei,inorder,isi,iei);
    }
}