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
        int sum=0;
        int maxsumlevel=1;
        
        while(q.size()>0){
            int size=q.size();
            List<Integer>lev=new ArrayList<>();
            while(size-->0){
                TreeNode rn=q.removeFirst();
                lev.add(rn.val);
                if(rn.left!=null){//add child to queue
                    q.addLast(rn.left);
                }
                if(rn.right!=null){
                    q.addLast(rn.right);
                }
            }
            for(int i=0;i<lev.size();i++){
                sum+=lev.get(i);
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