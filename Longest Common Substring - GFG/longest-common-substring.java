// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int lcsubstring(String s1,String s2,int N,int M,int[][]dp){
        int maxlen=0;
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n==0 || m==0){
                    dp[n][m]=0;
                    continue;
                }
                if(s1.charAt(n-1)==s2.charAt(m-1)){
                    dp[n][m]=dp[n-1][m-1]+1;
                    maxlen=Math.max(maxlen,dp[n][m]);
                }
            }
        }
        return maxlen;
    }
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int dp[][]=new int[n+1][m+1];
        
        return lcsubstring(s1,s2,n,m,dp);
    }
}