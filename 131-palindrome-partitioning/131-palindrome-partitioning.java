class Solution {
    boolean isPalindrome(String s,int si,int ei){
        while(si<ei){
            if(s.charAt(si)!=s.charAt(ei)){
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }
    public int part(String s,int idx,List<String>smallans,List<List<String>>ans){
        if(idx==s.length()){
            List<String>base=new ArrayList<>(smallans);
            ans.add(base);
            return 1;
        }
        int count=0;
        
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                smallans.add(s.substring(idx,i+1));
                count+=part(s,i+1,smallans,ans);
                smallans.remove(smallans.size()-1);
            }
        }
        return count;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>smallans=new ArrayList<>();
        part(s,0,smallans,ans);
        return ans;
    }
}