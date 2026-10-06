class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();
        q.add(new int[]{k, 0});
        int time = 0;

        while (!q.isEmpty() && visited.size() != n) {
            int[] node = q.poll();
            if (visited.contains(node[0])) continue;
            visited.add(node[0]);
            time = node[1];
            for (int[] nei : adj.get(node[0])) {
                if (!visited.contains(nei[0])) {
                    q.add(new int[]{nei[0], nei[1] + node[1]});
                }
            }
        }

        return visited.size() == n ? time : -1;
    }
}
