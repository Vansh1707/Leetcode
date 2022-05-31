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
    public ArrayList<TreeNode> NodeToRootPath(TreeNode root,TreeNode data){
        if(root==null) return new ArrayList<>();
        if(root.val==data.val){
            ArrayList<TreeNode>list=new ArrayList<>();
            list.add(root);
            return list;
        }
        ArrayList<TreeNode>lpath=NodeToRootPath(root.left,data);
        if(lpath.size()!=0){
            lpath.add(root);
            return lpath;
        }
        ArrayList<TreeNode>rpath=NodeToRootPath(root.right,data);
        if(rpath.size()!=0){
            rpath.add(root);
            return rpath;
        }
        return new ArrayList<>();
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        
//         TreeNode left=lowestCommonAncestor(root.left,p,q);
//         TreeNode right=lowestCommonAncestor(root.right,p,q);
//         if (left!=null && right!=null)
//             return root;
        
//         return (left != null) ? left : right;
        
        
        ArrayList<TreeNode>plist=NodeToRootPath(root,p);
        ArrayList<TreeNode>qlist=NodeToRootPath(root,q);
        int i=plist.size()-1;
        int j=qlist.size()-1;
        while(i>=0 && j>=0 && plist.get(i)==qlist.get(j)){            
            i--;
            j--;            
        }
        i++;
        j++;
        return plist.get(i);
        
    }
}