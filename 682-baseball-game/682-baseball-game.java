class Solution {
    public int calPoints(String[] ops) {
        int score=0;
        LinkedList<Integer>st=new LinkedList<>();
        
        for(int i=0;i<ops.length;i++){
            if("+".equals(ops[i])){
                int n1=st.removeFirst();
                int n2=st.getFirst()+n1;
                st.addFirst(n1);
                st.addFirst(n2);
            }else if("C".equals(ops[i])){
                st.removeFirst();
            }else if("D".equals(ops[i])){
                st.addFirst(st.getFirst()*2);
            }else{
                st.addFirst(Integer.parseInt(ops[i]));
            }
        }
        
        while(st.size()>0){
            score+=st.removeFirst();
        }
        return score;
    }
}