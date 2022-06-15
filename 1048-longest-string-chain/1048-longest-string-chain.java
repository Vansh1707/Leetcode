class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (String a, String b) -> a.length() - b.length()); // sort by length
        Map<String, Integer> dp = new HashMap<>();//{String,chainlength}
        
        int maxpath=1;
        for(String word:words){
            dp.put(word,1);
            for(int i=0;i<word.length();i++){
                StringBuilder curr=new StringBuilder(word);
                String next=curr.deleteCharAt(i).toString();
                if(dp.containsKey(next)){
                    dp.put(word,Math.max(dp.get(word),dp.get(next)+1));
                }
            }
            maxpath=Math.max(maxpath,dp.get(word));
        }
        return maxpath;
    }
}