class Solution {
    public List<List<Integer>> generate(int numrow) {
        List<List<Integer>>ans=new ArrayList<>();
        if(numrow==0)return ans;
        List<Integer>frow=new ArrayList<>();
        frow.add(1);
        ans.add(frow);
        
        for(int i=1;i<numrow;i++){
            List<Integer>prev=ans.get(i-1);
            List<Integer>smallans=new ArrayList<>();
            
            smallans.add(1);
            for(int j=1;j<i;j++){
                smallans.add(prev.get(j-1)+prev.get(j));
            }
            smallans.add(1);
            ans.add(smallans);
        }
        return ans;
    }
}