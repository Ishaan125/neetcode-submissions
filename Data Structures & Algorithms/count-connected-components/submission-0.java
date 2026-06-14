class Solution {
    List<List<Integer>> adj;
    boolean[] state;
    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        state = new boolean[n];
        int num = 0;

        for (int i = 0; i < n; i++) {
            if (!state[i]) {
                dfs(i);
                num++;
            }
        }
        return num;
    }

    private void dfs(int i) {
        state[i] = true;
        for (int n : adj.get(i)) {
            if (!state[n]) {
                dfs(n);
            }
        }
    }
}
