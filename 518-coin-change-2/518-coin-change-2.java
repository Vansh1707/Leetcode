class Solution {
    public int change(int Tar, int[] coins) {
        
        int[]dp=new int[Tar+1];
        dp[0]=1;
        for(int ele:coins){
            for(int tar=ele;tar<=Tar;tar++){
                if(tar-ele>=0)
                dp[tar]+=dp[tar-ele];
            }
        }
        return dp[Tar];
    }
}