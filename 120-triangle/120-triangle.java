class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)return triangle.get(0).get(0);
        int n=triangle.size();
        
        for(int i=1;i<n;i++){
            int m=triangle.get(i).size();
            for(int j=0;j<m;j++){
                int sum=0;
                if(j==0){
                    sum=triangle.get(i).get(j)+triangle.get(i-1).get(j);
                }else if(j==m-1){
                    sum=triangle.get(i).get(j)+triangle.get(i-1).get(triangle.get(i-1).size()-1);
                }else{
                    int min=Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1));
                    sum=min + triangle.get(i).get(j);
                }
                triangle.get(i).set(j,sum);
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}