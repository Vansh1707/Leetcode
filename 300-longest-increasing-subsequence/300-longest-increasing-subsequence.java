class Solution {
    public int LisTab(int[] arr, int[] dp) {
        int n=arr.length,maxlen=0;
        
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];

        return LisTab(arr,dp);
    }
}