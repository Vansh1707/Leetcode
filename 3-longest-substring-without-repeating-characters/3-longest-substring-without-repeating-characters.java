class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        int len=0,count=0;
        int si=0,ei=0;
        int[]freq=new int[128];
        
        int gsi=0,gei=0;//if that string is asked
        
        while(ei<s.length()){
            if(freq[s.charAt(ei++)]++ > 0) count++;
            
            while(count>0){
                if(freq[s.charAt(si++)]-->1) count--;
            }
            // len=Math.max(len,ei-si);
            if(ei-si>len){
                len=ei-si;
                gsi=si;
                gei=ei;
            }
            
        }
        // System.out.println(s.substring(gsi,gei));
        return len;
        
    }
}