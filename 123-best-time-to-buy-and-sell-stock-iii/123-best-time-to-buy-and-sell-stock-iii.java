class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        int[][][]dp=new int[n+1][3][2];
        
        for(int i=0;i<n;i++){
            for(int k=0;k<3;k++){
                for(int x=0;x<2;x++){
                    if(k==0){
                        if(x==0){
                            dp[i][k][x]=0;
                        }else{
                            dp[i][k][x]=-(int)1e9;
                        }
                    }else{
                        if(i==0){
                            if(x==0){
                                dp[i][k][x]=Math.max(0,-(int)1e9+prices[i]);
                            }else{
                                dp[i][k][x]=Math.max(-(int)1e9,0-prices[i]);
                            }
                        }else{
                            if(x==0){
                                dp[i][k][x]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                            }else{
                                dp[i][k][x]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                            }
                        }
                    }
                }
            }
        }
        return dp[n-1][2][0];
    }
}