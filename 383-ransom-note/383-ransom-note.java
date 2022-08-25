class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int freq[] = new int[26];
        for (char i : magazine.toCharArray()) {
            freq[i - 'a']++;
        }
        for (char i : ransomNote.toCharArray()) {
            if (freq[i - 'a'] == 0) {
                return false;
            } else {
                freq[i - 'a']--;
            }
        }
        return true;
    }
}