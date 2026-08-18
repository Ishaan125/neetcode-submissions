class Solution {
    private boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if (visited[i][j]) return 0;
        int total = 0;
        visited[i][j] = true;
        return total + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1)
                + dfs(grid, i, j+1);
    }
}