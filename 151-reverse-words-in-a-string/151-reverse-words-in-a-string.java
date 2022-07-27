class Solution {
   
    public String reverseWords(String s) {
        //The trim() method eliminates leading and trailing spaces.
//Then, split by \s+ which will match one or more whitespace characters in between the words.
        String[]sarr=s.trim().split("\s+");
        int n=sarr.length;
        int si=0,ei=n-1;
        
        while(si<ei){
            String temp=sarr[si];
            sarr[si]=sarr[ei];
            sarr[ei]=temp;
            si++;
            ei--;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==n-1){
                sb.append(sarr[i]);
            }else{
                sb.append(sarr[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
        
    }
}