class Solution {
    public int minCostConnectPoints(int[][] points) {
        int total = 0;
        int edges = 0;
        int node = 0;
        int[] distances = new int[points.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[points.length];

        while (edges < points.length - 1) {
            visited[node] = true;
            int next = -1;
            for (int i = 0; i < points.length; i++) {
                if (visited[i]) continue;
                int curDist = Math.abs(points[i][0] - points[node][0]) +
                              Math.abs(points[i][1] - points[node][1]);
                distances[i] = Math.min(distances[i], curDist);
                if (next == -1 || distances[i] < distances[next]) {
                    next = i;
                }
            }
            edges++;
            total += distances[next];
            node = next;
        }
        return total;
    }
}


// iterate through points
// add univisted point with smallest weight 
// mark as visited, update total, and go to that edge
// go until edges = vertices - 1
// res = sum(distances)