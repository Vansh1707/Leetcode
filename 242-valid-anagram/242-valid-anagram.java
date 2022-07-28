class Solution {
    public boolean isAnagram(String s, String t) {
        int freq[]=new int[128];//lower case english
        
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]--;
        }
        
        for(int i=0;i<128;i++){
            if(freq[i]!=0){
                return false;
            }
            
        }
        return true;
    }
}