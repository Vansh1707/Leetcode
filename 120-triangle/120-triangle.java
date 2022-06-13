class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)return triangle.get(0).get(0);
        int n=triangle.size();
        
        for(int i=n-2;i>=0;i--){
            int m=triangle.get(i).size();
            for(int j=0;j<m;j++){
                int min=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                int sum=min+triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }                
        }            
        return triangle.get(0).get(0) ;
    }
}