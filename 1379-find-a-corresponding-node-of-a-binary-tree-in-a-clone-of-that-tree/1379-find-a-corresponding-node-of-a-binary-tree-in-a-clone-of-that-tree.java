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
    public final TreeNode travel(final TreeNode root, final TreeNode target){
        TreeNode res;
        if(root == null) 
            return null;
        if(root.val == target.val)// if found target return node which has same value as target
            return root;
        res = travel(root.left, target);// go left
        if(res == null) // if did't found go right;
            res = travel(root.right, target);
        return res;
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return travel(cloned, target);
    }
}