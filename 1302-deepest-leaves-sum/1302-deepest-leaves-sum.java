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
    public int deepestLeavesSum(TreeNode root) {
        int sum=0;
        if(root==null)return 0;
        LinkedList<TreeNode>q=new LinkedList<>();
        q.addLast(root);
        List<List<Integer>>list=new ArrayList<>();
        while(q.size()>0){
            int size=q.size();
            List<Integer>lev=new ArrayList<>();
            while(size-->0){
                TreeNode rn=q.removeFirst();
                lev.add(rn.val);
                if(rn.left!=null)q.addLast(rn.left);
                if(rn.right!=null)q.addLast(rn.right);
            }
            list.add(lev);
        }
        int n=list.size();
        for(int ele:list.get(n-1))
            sum+=ele;
        
        return sum;
    }
}