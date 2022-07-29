class Solution {
    private Boolean matches(String word,String pattern){
        char[]patterntoword=new char[26];
        char[]wordtopattern=new char[26];
        for(int i=0;i<word.length();i++){
            char w=word.charAt(i);
            char p=pattern.charAt(i);
            
            if(patterntoword[p-'a']==0){
                patterntoword[p-'a']=w;
            }
            if(wordtopattern[w-'a']==0){
                wordtopattern[w-'a']=p;
            }
            
            if(patterntoword[p-'a']!=w ||wordtopattern[w-'a']!=p){
                return false;
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String>ans=new ArrayList<>();
        
        for(String word:words){
            if(matches(word,pattern)){
                ans.add(word);
            }
        }
        
        return ans;
    }
}