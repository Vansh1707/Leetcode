class Solution {
    public List<List<Integer>> generate(int numrow) {
        List<List<Integer>>ans=new ArrayList<>();
        if(numrow==0)return ans;
        List<Integer>firstrow=new ArrayList<>();
        firstrow.add(1);
        ans.add(firstrow);
        
        for(int i=1;i<numrow;i++){
            List<Integer>prevrow=ans.get(i-1);
            List<Integer>smallans=new ArrayList<>();
            
            smallans.add(1);// first 1
            
            for(int j=1;j<i;j++){
                smallans.add(prevrow.get(j-1)+prevrow.get(j));
            }
            smallans.add(1);//last 1
            ans.add(smallans);
        }
        return ans;
    }
}