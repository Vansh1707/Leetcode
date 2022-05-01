class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='#'){
                if(sb1.length()==0)continue;
                sb1.delete(sb1.length()-1,sb1.length());                
            }else{
                sb1.append(ch);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(ch=='#'){
                if(sb2.length()==0)continue;
                sb2.delete(sb2.length()-1,sb2.length());                
            }else{
                sb2.append(ch);
            }
        }
        
        return sb1.toString().equals(sb2.toString());
    }
}