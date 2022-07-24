class Solution {
    public boolean searchMatrix(int[][] matrix, int tar) {
        int n=matrix.length,m=matrix[0].length;
        int si=n-1,ei=0;
        while(si>=0 && ei<m){
            int ele=matrix[si][ei];
            if(ele==tar)
                return true;
            else if(ele<tar)
                ei++;
            else
                si--;
        }
        return false;
    }
}