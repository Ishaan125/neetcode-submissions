class Solution {
    List<List<Integer>> adj;
    int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }
        state = new int[numCourses];
        // 0(not processed), 1(dfs), 2(done)
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr) {
        state[curr] = 1;
        for (int i : adj.get(curr)) {
            if (state[i] == 1) {
                return true;
            }
            if (state[i] == 0 && dfs(i)) {
                return true;
            }
        }
        state[curr] = 2;
        return false;
    }
}
