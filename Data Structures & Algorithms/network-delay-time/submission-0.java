class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            if (!adj.containsKey(time[0])) {
                adj.put(time[0], new ArrayList<>());
            }
            adj.get(time[0]).add(new int[]{time[1], time[2]}); // target, time
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.offer(new int[]{k, 0}); // target, time
        Set<Integer> visited = new HashSet<>();
        int time = 0;

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            if (visited.contains(curr[0])) {
                continue;
            }
            visited.add(curr[0]);
            time = curr[1];

            if (adj.containsKey(curr[0])) {
                for (int[] path : adj.get(curr[0])) {
                    if (!visited.contains(path[0])) {
                        heap.offer(new int[]{path[0], path[1]+curr[1]});
                    }
                }
            }
        }
        return visited.size() == n ? time : -1;
    }
}
