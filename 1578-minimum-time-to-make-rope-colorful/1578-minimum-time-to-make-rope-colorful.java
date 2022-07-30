class Solution {
    public int minCost(String s, int[] cost) {
        int ans=0;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)){
                ans+=Math.min(cost[i-1],cost[i]);
                cost[i]=Math.max(cost[i-1],cost[i]);
            }
        }
        return ans;
    }
}