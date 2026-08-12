class Solution {
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2*n - 1];
        diag2 = new boolean[2*n - 1];
        return dfs(n, 0);
    }

    private int dfs(int n, int row) {
        if (row == n) {
            return 1;
        }
        int ways = 0;

        for (int j = 0; j < n; j++) {
            if (!cols[j] && !diag1[row - j + (n-1)] && !diag2[row + j]) {
                cols[j] = true;
                diag1[row - j + (n-1)] = true;
                diag2[row + j] = true;
                ways += dfs(n, row + 1);
                cols[j] = false;
                diag1[row - j + (n-1)] = false;
                diag2[row + j] = false;
            }
        }
        
        return ways;
    }
}