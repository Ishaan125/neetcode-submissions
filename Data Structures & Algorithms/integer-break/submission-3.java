class Solution {
    private int[] memo;
    public int integerBreak(int n) {
        memo = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int max = 1;

        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * Math.max(n - i, dfs(n - i)));
        }

        return memo[n] = max;
    }
}