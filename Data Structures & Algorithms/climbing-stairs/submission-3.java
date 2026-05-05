class Solution {
    /*
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        return helper(n, arr);
    }

    private int helper(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }

        arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        return arr[n];
    }
    */
    /*
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prevPrev = 1;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + prevPrev;
            prevPrev = prev;
            prev = curr;
        }
        return prev;
    }
}
