class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int si=0,ei=0,gsi=0,len=Integer.MAX_VALUE,count=t.length();
        int[] freq=new int[128];
        
        for(int i=0;i<t.length();i++)
            freq[t.charAt(i)]++;
        
        while(ei<s.length()){
            if(freq[s.charAt(ei)]>0) count--;
            freq[s.charAt(ei)]--;
            ei++;
            
            while(count==0){
                if(ei-si<len){
                    len=ei-si;
                    gsi=si;
                }
                if(freq[s.charAt(si)] == 0){
                    count++;                   
                }
                freq[s.charAt(si)]++;
                si++;
            }
        }
        return len==Integer.MAX_VALUE ? "" : s.substring(gsi,gsi+len);
    }
}