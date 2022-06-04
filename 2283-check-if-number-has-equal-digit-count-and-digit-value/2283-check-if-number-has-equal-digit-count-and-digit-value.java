class Solution {
    public boolean digitCount(String num) {
        if(num.length()==0)return false;
        int[]freq=new int[10];
        
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            freq[ch-'0']++;
        }
        
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            if(freq[i]!=ch-'0'){
                return false;
            }
        }
        return true;
    }
}