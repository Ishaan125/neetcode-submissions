class Solution {
    /*
    private int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] item : memo) {
            Arrays.fill(item, -1);
        }
        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int mc, int nc) {
        if (mc == m - 1 && nc == n - 1) {
            return 1;
        }
        if (mc >= m || nc >= n) {
            return 0;
        }
        if (memo[mc][nc] != -1) {
            return memo[mc][nc];
        }
        return memo[mc][nc] = (helper(m, n, mc+1, nc) + helper(m, n, mc, nc+1));
    }
    */

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                dp[i][j] += dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
