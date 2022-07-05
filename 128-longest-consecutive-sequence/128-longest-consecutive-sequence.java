class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int ele:nums)
            set.add(ele);
        
        int len=0;
        for(int ele:nums){
            if(!set.contains(ele)) continue;
            int ple=ele-1,pre=ele+1;
            
            set.remove(ele);
            while(set.contains(ple)) set.remove(ple--);
            while(set.contains(pre)) set.remove(pre++);
            
            len=Math.max(len,pre-ple-1);
        }
        return len;
    }
}