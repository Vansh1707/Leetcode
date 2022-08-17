class Solution {
    private String transformMorse(String word, String[] arr) {
        StringBuilder build = new StringBuilder();
        for (char c : word.toCharArray())
            build.append(arr[(int)c - 'a']);
        return build.toString();
    }
    
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> set = new HashSet<>();
        for (String word : words) 
            set.add(transformMorse(word, arr));
        return set.size();
    }
    
}