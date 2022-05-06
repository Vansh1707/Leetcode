class Solution {
    
    public String removeDuplicates(String s, int k) {
        Stack<int[]>st=new Stack<>();//{char,count}
        int popcount=k;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.size()>0 && st.peek()[0]==ch){
                st.peek()[1]++;
            }
            else{
                st.push(new int[]{ch,1});
            }
            if(st.peek()[1]==k){
                st.pop();
            }
        }
        
        StringBuilder sb=new StringBuilder();
        while(st.size()>0){
            int[]top=st.pop();
            while(top[1]-->0)
                sb.append((char)top[0]);
        }
        return sb.reverse().toString();
        
    }
}