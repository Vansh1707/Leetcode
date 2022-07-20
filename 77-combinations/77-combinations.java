class Solution {
    public int combine(int n, int k,int idx,List<List<Integer>>ans,List<Integer>smallans) {
        if(k==0){
            List<Integer>base=new ArrayList<>(smallans);
            ans.add(base);
            return 1;
        }
        int count=0;
        for(int i=idx;i<=n-k+1;i++){            
            smallans.add(i);
            count+=combine(n,k-1,i+1,ans,smallans);
            smallans.remove(smallans.size()-1);   
        }
        return count;
        
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>smallans=new ArrayList<>();
        combine(n,k,1,ans,smallans);
        return ans;
    }
}