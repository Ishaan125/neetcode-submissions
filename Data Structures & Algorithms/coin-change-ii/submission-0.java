class Solution {
    private int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        Arrays.sort(coins);
        return helper(amount, coins, 0);
    }

    private int helper(int amount, int[] coins, int i) {
        int total = 0;
        if (amount == 0) {
            return 1;
        }
        if (i >= coins.length || amount < 0) {
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        total += helper(amount - coins[i], coins, i);
        total += helper(amount, coins, i+1);

        return dp[i][amount] = total;
    }
}
