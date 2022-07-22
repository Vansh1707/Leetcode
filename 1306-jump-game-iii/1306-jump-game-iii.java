class Solution {
    public boolean canReach(int[] arr, int start) {
        LinkedList<Integer>q=new LinkedList<>();
        q.addLast(start);
        
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int rp=q.removeFirst();
                //move left
                if(rp-arr[rp]>=0){
                    if(arr[rp-arr[rp]]==0)return true;
                    else if(arr[rp-arr[rp]]>0) q.addLast(rp-arr[rp]);
                }
                //move right
                if(rp+arr[rp]<arr.length){
                    if(arr[rp+arr[rp]]==0)return true;
                    else if(arr[rp+arr[rp]]>0) q.addLast(rp+arr[rp]);
                }
                arr[rp]=-1;
            }            
        }
        return false;
    }
}