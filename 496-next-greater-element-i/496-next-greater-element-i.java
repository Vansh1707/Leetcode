class Solution {
    private int[] NextGreaterRight(int[]nums){
        LinkedList<Integer>st=new LinkedList<>();
        int ans[]=new int[nums.length];
        
        for(int i=nums.length-1;i>=0;i--){
            while(st.size()>0 && st.getFirst()<nums[i])
                st.removeFirst();
            ans[i]=st.size()>0?st.getFirst():-1;
            
            st.addFirst(nums[i]);
        }
        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]ngr=NextGreaterRight(nums2);
        HashMap<Integer,Integer>hm=new HashMap<>();
        
        for(int i=0;i<nums2.length;i++){
            hm.put(nums2[i],ngr[i]);
            //System.out.println(ngr[i]);
        }
        
        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=hm.get(nums1[i]);
        }
        return res;
    }
}