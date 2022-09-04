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
    public class Pair{
        TreeNode node=null;
        int hl=0;
        
        Pair(TreeNode node ,int hl){
            this.node=node;
            this.hl=hl;
        }
    }
    public void width(TreeNode node,int hl,int minmax[]){
        if(node==null) return;
        
        minmax[0]=Math.min(minmax[0],hl);
        minmax[1]=Math.max(minmax[1],hl);
        
        width(node.left,hl-1,minmax);
        width(node.right,hl+1,minmax);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Pair>childq=new PriorityQueue<>((a,b)->{
            return a.node.val-b.node.val;
        });
        PriorityQueue<Pair>parq=new PriorityQueue<>((a,b)->{
            return a.node.val-b.node.val;
        });
        
        int[]minmax=new int[2];
        width(root,0,minmax);
        int len=minmax[1]-minmax[0]+1;
        List<List<Integer>>ans=new ArrayList<>();
        
        for(int i=0;i<len;i++){
            ans.add(new ArrayList<>());
        }
        
        parq.add(new Pair(root,Math.abs(minmax[0])));
        while(parq.size()>0){
            int size=parq.size();
            while(size-->0){
                Pair rp=parq.remove();
                TreeNode node=rp.node;
                int hl=rp.hl;
                
                ans.get(hl).add(node.val);
                
                if(node.left!=null) childq.add(new Pair(node.left,hl-1));
                if(node.right!=null) childq.add(new Pair(node.right,hl+1));
            }
            PriorityQueue<Pair> temp=parq;
            parq=childq;
            childq=temp;
        }
        return ans;
        
    }
}