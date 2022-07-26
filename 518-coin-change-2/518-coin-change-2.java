class Solution {
    private int change(int tar, int[] coins,int idx,int[][]dp) {
        if(tar==0)return 1;
        //if(tar<0)return 0;
        if(dp[idx][tar]!=-1)return dp[idx][tar];
        
        int count=0;
        for(int i=idx;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=change(tar-coins[i],coins,i,dp);
            }
        }
        dp[idx][tar]=count;
        return dp[idx][tar];
        
    }
    public int change(int tar, int[] coins) {
        int n=coins.length;
        int[][]dp=new int[n][tar+1];
        for(int[]d:dp)
            Arrays.fill(d,-1);
        
        return change(tar,coins,0,dp);
        
    }
}