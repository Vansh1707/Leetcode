class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        int[]freq=new int[26];
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        int count=0;
        Arrays.sort(freq);
        
        for(int i=0;i<freq.length;i++){
            // checking condition that value is greater than zero
            // here we are adding value in hashset and add method return true
            // if it add value in set and it and return false if it can't value beacuse there is some value already exist in it
            while(freq[i] > 0 && !set.add(freq[i]--))
                count++;
        }
        return count;
    }
}