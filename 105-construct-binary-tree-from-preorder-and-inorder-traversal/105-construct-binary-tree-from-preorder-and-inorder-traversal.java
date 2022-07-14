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
    public TreeNode buildTree(int[] preorder,int psi,int pei,int[] inorder,int isi,int iei){
        if(psi>pei)return null;
        
        int idx=isi;
        while(inorder[idx]!=preorder[psi])idx++;
        
        int numofele=idx-isi;
        TreeNode root=new TreeNode(preorder[psi]);
        root.left=buildTree(preorder,psi+1,psi+numofele,inorder,isi,idx-1);
        root.right=buildTree(preorder,psi+1+numofele,pei,inorder,idx+1,iei);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int psi=0,pei=preorder.length-1;
        int isi=0,iei=inorder.length-1;
        
        
        return buildTree(preorder,psi,pei,inorder,isi,iei);
    }
}