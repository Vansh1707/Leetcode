class Solution {
     public int subsets(int[] arr,int idx,List<List<Integer>>ans, List<Integer>smallans,boolean prev) {
        if(idx==arr.length){
            List<Integer>base=new ArrayList<>(smallans);
            ans.add(base);
            return 1;
        }
        int count=0;
        count+=subsets(arr,idx+1,ans,smallans,false);
            if(idx>0 && arr[idx]==arr[idx-1] && !prev)
                return 1;
         
            smallans.add(arr[idx]);
            count+=subsets(arr,idx+1,ans,smallans,true);
            smallans.remove(smallans.size()-1);
                   
        
        
        
        return count;
     }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>smallans=new ArrayList<>();
        subsets(nums,0,ans,smallans,false);
        return ans;
    }
}