class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        
        int time = 0;
        for(int[] course: courses) {
            int duration = course[0], lastDay = course[1];
            time += duration;
            pq.add(duration);
            // if pass the last day, remove courses these take longest time.
            if(time > lastDay) {
                time -= pq.remove();
            }
        }
        return pq.size();
    }
}