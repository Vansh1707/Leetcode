class Solution {
    private boolean subset(int []src,int []dest){
        for(int i=0;i<26;i++){
            if(dest[i]>src[i])return false;
        }
        return true;
    }
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String>ans=new ArrayList<>();
        int[]tar=new int[26];
        
        for(String b:B){
            int temp[]=new int[26];
            
            for(char c:b.toCharArray()){
                temp[c-'a']++;
                tar[c-'a']=Math.max(tar[c-'a'],temp[c-'a']);
            }
            
        }
        
        for(String a:A){
            int[]arr=new int[26];
            
            for(char c:a.toCharArray())arr[c-'a']++;
            
            if(subset(arr,tar)){
                ans.add(a);
            }
        }
        return ans;
    }
}