class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set <Integer> set = new HashSet <> ();
        Map <Integer, Integer> map = new HashMap <> ();
        for (int num : arr)
            map.put (num, map.getOrDefault(num, 0) + 1);
        for (int val : map.values())
            set.add (val);
        return set.size() == map.size();
    }
}