class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> fmap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> fmap.get(b) - fmap.get(a));
        
        for (int num : arr) fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        
        for (Integer key : fmap.keySet()) pq.add(key);

        int size = arr.length; int res = 0;
        while (size > arr.length / 2) {
            size -= fmap.get(pq.remove());
            res++;
        }

        return res;
        
    }
}