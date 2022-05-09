class Solution {
    String[] keypad=new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public void printKPC(String str, String asf,List<String>ans) {
        if (str.length() == 0) {
            ans.add(asf);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);

        int idx = ch - '0'; //char-->int
        String word = keypad[idx];

        for(int i=0;i<word.length();i++){
            printKPC(roq,asf+word.charAt(i),ans);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String>ans=new LinkedList<>();
        if(digits.length()==0)return ans;
              
        printKPC(digits,"",ans);        
        
        return ans;
    }
}