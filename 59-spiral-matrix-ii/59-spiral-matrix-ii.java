class Solution {
    public int[][] generateMatrix(int n) {
        int [][]result=new int[n][n];
        int num=1;
        int left = 0;
        int right = n-1;
        int down = n-1;
        int top = 0;
        
        while(num<=n*n){
            //right
            for (int i = left;i<=right;i++){
                result[top][i] = num;
                num++;
            }
            top++;
            //down
            for (int i = top;i<=down;i++){
                result[i][right] = num;
                num++;
            }
            right--;
            //left
            for (int i = right;i>=left;i--){
                result[down][i] = num;
                num++;
            }
            down--;
            //up
            for(int i=down;i>=top;i--){
                result[i][left]=num;
                num++;
            }
            left++;
        }
        return result;
    }
}