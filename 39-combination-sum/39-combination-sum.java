class Solution {
    public int combInfiCoin(int[]arr,int tar,int idx,List<List<Integer>>ans,List<Integer>smallans){
        if(tar==0){
            List<Integer>base=new ArrayList<>(smallans);
            ans.add(base);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++){            
            if(tar-arr[i]>=0){
                smallans.add(arr[i]);
                count+=combInfiCoin(arr,tar-arr[i],i,ans,smallans);
                smallans.remove(smallans.size()-1);
            }
        }
        return count;
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>smallans=new ArrayList<>();
        combInfiCoin(candidates,target,0,ans,smallans);
        return ans;
    }
}