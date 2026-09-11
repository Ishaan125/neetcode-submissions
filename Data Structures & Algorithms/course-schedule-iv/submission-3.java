class Solution {
    private List<List<Integer>> adj;
    private Boolean[][] preq;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList<>();
        List<Boolean> res = new ArrayList<>();
        preq = new Boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
        }
        for (int[] arr : queries) {
            res.add(dfs(arr[0], arr[1]));
        }
        return res;
    }

    private boolean dfs(int i, int j) {
        if (preq[i][j] != null) {
            return preq[i][j];
        }
        for (int nei : adj.get(i)) {
            if (nei == j || dfs(nei, j)) {
                return preq[i][j] = true;
            }
        }
        return preq[i][j] = false;
    }
}