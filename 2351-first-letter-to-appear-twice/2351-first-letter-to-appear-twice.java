class Solution {
    public char repeatedCharacter(String s) {
        if(s.length() <= 0 || s == null){
            return '\0';
        }
        int[]freq=new int[26];
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
            if(freq[ch-'a']>1)return ch;
        }
        return '\0';
    }
}