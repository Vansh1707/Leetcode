class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<int[]>list=new ArrayList<>();
        
        list.add(arr[0]);
        int idx=0;
        for(int i=1;i<arr.length;i++){
            int[]interval=list.get(idx);
            
            if(arr[i][0]<=interval[1]){
                interval[1]=Math.max(interval[1],arr[i][1]);
            }else{
                list.add(arr[i]);
                idx++;
            }
        }
        int[][]ans=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}