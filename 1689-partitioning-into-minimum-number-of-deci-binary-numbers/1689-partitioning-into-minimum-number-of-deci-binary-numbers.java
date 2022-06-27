class Solution {
    public int minPartitions(String s) {
        int n=s.length();
        
        int max = 0;
        for (int i=0; i<n; i++) {
            //if (s.charAt(i) - '0' == 9) return 9;
            max = Math.max(max, (s.charAt(i) - '0'));
        }
        return max;
    }
}