class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n=operations.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(operations[i].charAt(1)=='+')
             count=count+1;
            else
             count=count-1;
        }
        return count;
    }
}