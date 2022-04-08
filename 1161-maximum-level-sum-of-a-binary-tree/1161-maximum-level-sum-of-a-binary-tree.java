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
    public int maxLevelSum(TreeNode root) {
        if(root==null)return 0;
        
        LinkedList<TreeNode>q=new LinkedList<>();
        q.addLast(root);
        int levcount=1;
        int max=-(int)1e9;
        int maxsumlevel=1;
        
        while(q.size()>0){
            int size=q.size();
            int sum=0;
            while(size-->0){
                TreeNode rn=q.removeFirst();
                sum+=rn.val;
                if(rn.left!=null){//add child to queue
                    q.addLast(rn.left);
                }
                if(rn.right!=null){
                    q.addLast(rn.right);
                }
            }
            if(sum>max){
                maxsumlevel=levcount;
                max=sum;
            }
            levcount++;
            sum=0;
        }
        return maxsumlevel;
    }
}