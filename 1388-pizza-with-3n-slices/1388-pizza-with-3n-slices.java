class Solution {
    public int maxSizeSlices(int[] slices, int si, int ei, int NoOfSlices, int[][] dp) {
        if (si > ei || NoOfSlices == 0) {
            return 0;
        }
        if (dp[ei][NoOfSlices] != -1)
            return dp[ei][NoOfSlices];
        int takeThisSlice = maxSizeSlices(slices, si, ei - 2, NoOfSlices - 1, dp) + slices[ei];
        int leaveThisSlice = maxSizeSlices(slices, si, ei - 1, NoOfSlices, dp);

        return dp[ei][NoOfSlices] = Math.max(takeThisSlice, leaveThisSlice);
    }
    public int maxSizeSlices(int[] slices) {
         int n = slices.length;
        int[][] dp1 = new int[n + 1][n / 3 + 1];
        int[][] dp2 = new int[n + 1][n / 3 + 1];

        for (int[] d : dp1)
            Arrays.fill(d, -1);
        for (int[] d : dp2)
            Arrays.fill(d, -1);

        return Math.max(maxSizeSlices(slices, 0, n - 2, n / 3, dp1), maxSizeSlices(slices, 1, n - 1, n / 3, dp2));
    }
}