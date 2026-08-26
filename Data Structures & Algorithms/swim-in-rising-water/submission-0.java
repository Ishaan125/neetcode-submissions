class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int l = Math.max(grid[0][0], grid[rows-1][cols-1]);
        int r = grid[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                r = Math.max(r, grid[i][j]);
            }
        }

        int res = r;
        while (l <= r) {
            int m = l + (r-l) / 2;
            if (!dfs(grid, m, 0, 0, new HashSet<>())) {
                l = m + 1;
            }
            else {
                r = m - 1;
                res = Math.min(res, m);
            }
        }

        return res;
    }

    private boolean dfs(int[][] grid, int t, int i, int j, Set<Integer> visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] > t || visited.contains(grid[i][j])) {
            return false;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }

        visited.add(grid[i][j]);
        return dfs(grid, t, i + 1, j, visited) || dfs(grid, t, i, j + 1, visited) || 
            dfs(grid, t, i - 1, j, visited) || dfs(grid, t, i, j - 1, visited);
    }
}
