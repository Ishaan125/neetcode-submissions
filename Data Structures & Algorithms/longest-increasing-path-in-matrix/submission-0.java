class Solution {
    private int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j) {
        int max = 1;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i > 0 && matrix[i-1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i-1, j));
        }
        if (i < matrix.length-1 && matrix[i+1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i+1, j));
        }
        if (j > 0 && matrix[i][j-1] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i, j-1));
        }
        if (j < matrix[0].length-1 && matrix[i][j+1] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i, j+1));
        }
        return dp[i][j] = max;
    }
}
