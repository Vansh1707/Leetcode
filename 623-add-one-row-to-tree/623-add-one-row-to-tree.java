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
    private void bfs(TreeNode root, int val, int depth){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < depth - 2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode curr = queue.poll();
                if (curr.left != null){ 
                    queue.add(curr.left);
                }
                if (curr.right != null){ 
                    queue.add(curr.right);
                }
            }
        }
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = new TreeNode(val);
            curr.left.left = temp;
            
            temp = curr.right;
            curr.right = new TreeNode(val);
            curr.right.right = temp;
        }
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        bfs(root, val, depth);
        return root;
    }
}