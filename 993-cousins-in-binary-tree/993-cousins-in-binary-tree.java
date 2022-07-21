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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;

        Queue<TreeNode> q= new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int levelSize= q.size();
            List<Integer> level= new ArrayList(levelSize);
            
            for(int i=0;i<levelSize;i++){ 
                TreeNode temp = q.poll();
                if(temp.left != null && temp.right != null){
                    //if x and y are found from the same parent node they can't be cousins early break out
                    if(temp.left.val == x && temp.right.val == y)
                        return false;
                    if(temp.right.val == x && temp.left.val == y)
                        return false;
                }
                level.add(temp.val);
                //add child nodes   
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            //check at next levels for cousins
            if(level.contains(x) && level.contains(y))
                return true;
        }
        return false;
    }
}