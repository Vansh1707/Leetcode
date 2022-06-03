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
    public void inorder(TreeNode root,ArrayList<Integer>list){
        if(root==null) return;
        
        inorder(root.left,list);
        
        list.add(root.val);
        
        inorder(root.right,list);
    }
    public TreeNode bstcon(ArrayList<Integer>list,int si,int ei){
        if(si>ei) return null;
        int mid=si+(ei-si)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=bstcon(list,si,mid-1);
        root.right=bstcon(list,mid+1,ei);
        
        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer>list=new ArrayList<>();
        inorder(root,list);
        return bstcon(list,0,list.size()-1);
    }
}