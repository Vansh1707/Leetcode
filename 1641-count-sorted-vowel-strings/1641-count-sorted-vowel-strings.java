class Solution {
    char[]ch=new char[]{'a','e','i','o','u'};
    
    int cvs(int len,char lastchar){
        if(len==0)return 1;
        int temp=0;
        for(char c:ch){
            if(lastchar>=c){
                temp+=cvs(len-1,c);
            }
        }
        return temp;
    }
    public int countVowelStrings(int n) {
        int ans=0;
        for(char c:ch){
            ans+=cvs(n-1,c);
        }
        return ans;
    }
}