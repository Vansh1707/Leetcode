class Solution {
    public boolean isInterleave(int p1,int p2,int p3,String s1, String s2, String s3,Boolean[][] dp) {
        
         if(p1==s1.length() && p2==s2.length() && p3 == s3.length()){
            return true;
        }
        if(dp[p1][p2]!=null) return dp[p1][p2]; 
        
        if(p1<s1.length() && p3<s3.length() &&s1.charAt(p1)==s3.charAt(p3)){
            if(isInterleave(p1+1,p2,p3+1,s1,s2,s3,dp))
                return dp[p1][p2]=true;
        }
        if(p2<s2.length() && p3<s3.length() &&s2.charAt(p2)==s3.charAt(p3)){
            if(isInterleave(p1,p2+1,p3+1,s1,s2,s3,dp))
                return dp[p1][p2]=true;
        }
        return dp[p1][p2]=false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        for(Boolean[] arr : dp) Arrays.fill(arr,null);
        
        return isInterleave(0,0,0,s1,s2,s3,dp);
    }
}