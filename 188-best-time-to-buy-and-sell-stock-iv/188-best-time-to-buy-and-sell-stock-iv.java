class Solution {
    public int maxProfit(int k, int[] prices) {
         if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < n; d++) {
                max = Math.max(max, dp[t - 1][d - 1] - prices[d - 1]);
                dp[t][d] = Math.max(max + prices[d], dp[t][d - 1]);
            }
        }
        return dp[k][n - 1];
    }
}