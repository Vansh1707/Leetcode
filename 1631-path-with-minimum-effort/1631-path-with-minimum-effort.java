class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int directions[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        int[][] weights = new int[m][n];
		
		for (int i=0; i < m; i++) {
            Arrays.fill(weights[i], Integer.MAX_VALUE);
        }
		
        PriorityQueue< int[] > queue = new PriorityQueue< int[] >((int[] a, int b[])->{
            return a[2]-b[2];
        });
		
        weights[0][0] = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0], j = p[1];
            if (i == m-1 && j == n-1)
                break;
            visited[i][j] = true;
            for (int d[]: directions) {
                int k = i+d[0], l = j+d[1];
                if (k<0 || k==m || l<0 || l==n || visited[k][l]) {
                    continue;
                }
                int weight = Math.max(weights[i][j], Math.abs(heights[i][j] - heights[k][l]));
                if (weight < weights[k][l]) {
                    weights[k][l] = weight;
                    queue.add(new int[]{k, l, weight});
                }
            }
        }
        return weights[m-1][n-1];
    }
}