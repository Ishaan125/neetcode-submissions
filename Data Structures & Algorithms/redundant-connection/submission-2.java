class Solution {
    private List<List<Integer>> adj;
    public int[] findRedundantConnection(int[][] edges) {
        adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visited = new boolean[n+1];
            visited[edge[0]] = true;
            if (cycle(edge[0], edge[1], visited)) {
                return edge;
            }
        }
        return new int[2];
    }

    private boolean cycle(int par, int curr, boolean[] visited) {
        if (visited[curr]) return true;
        visited[curr] = true;
        for (int nei : adj.get(curr)) {
            if (nei == par) continue;
            if (cycle(curr, nei, visited)) return true;
        }
        return false;
    }
}
