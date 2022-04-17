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
    List<TreeNode> li = new ArrayList<>();
    
    public void addInList(TreeNode root) {
        if(root == null)
            return;
        addInList(root.left);
        li.add(root);
        addInList(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        addInList(root);
        int len = li.size();
        for(int i=0; i<len-1; i++) {
            li.get(i).right = li.get(i+1);
            li.get(i).left = null;
        }
        li.get(len-1).left = null;
        li.get(len-1).right = null;
        return li.get(0);
    }
}