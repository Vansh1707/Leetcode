class Solution {
    public void permute_(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] vis){
        if(list.size()==nums.length){
            ans.add(new ArrayList(list));
            return;
        }
        int prev=-12;
        for(int i=0;i<nums.length;i++){
            if(!vis[i] && prev!=nums[i]){
                vis[i]=true;
                list.add(nums[i]);
                permute_(ans,list,nums,vis);
                list.remove(list.size()-1);
                prev=nums[i];
                vis[i]=false;
            }
        }
        
        
            
    }  
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean vis[]=new boolean[nums.length];
        Arrays.sort(nums);
        permute_(ans, list, nums,vis);
        return ans;
    }
}