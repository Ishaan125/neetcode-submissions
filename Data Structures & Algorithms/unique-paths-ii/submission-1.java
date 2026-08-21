class Solution {
    private int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(obstacleGrid, 0, 0);
    }
    private int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        return dp[i][j] = dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
    }

}