class Solution {
    public void wordBreak_revEngg(String s,int idx,boolean[] dp,int len, List<String> wordDict,HashSet<String>set,String ssf,List<String>ans){
        
        if(idx>=s.length()){
            ans.add(ssf.substring(0,ssf.length()-1));
            return;
        } 
        
        for(int l=1;l<=len && idx+l<=s.length();l++){
            if(dp[idx+l]){
                String substr=s.substring(idx,idx+l);
                if(set.contains(substr)){
                    wordBreak_revEngg(s,idx+l,dp,len,wordDict,set,ssf+substr+" ",ans);
                }
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>();
        int len=0,n=s.length();
        for(String ss: wordDict){
            set.add(ss);
            len=Math.max(ss.length(),len);
        }
        boolean dp[]=new boolean[n+1];
        dp[0]=true;
        for(int i=0;i<=n;i++){
            if(!dp[i]) continue;
            
            for(int l=1;l<=len && i+l<=n;l++){
                String substr=s.substring(i,i+l);
                if(set.contains(substr)){
                    dp[i+l]=true;
                }
            }
        }
        List<String>ans=new ArrayList<>();
        if(dp[n])
            wordBreak_revEngg(s,0,dp,len,wordDict,set,"",ans);
            
        return ans;
    }
}