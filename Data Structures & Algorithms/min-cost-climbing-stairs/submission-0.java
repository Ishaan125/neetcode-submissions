class Solution {
    /*
    private int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length+1];
        Arrays.fill(memo, -1);
        return Math.min(helper(0, cost), helper(1,cost));
    }

    private int helper(int i, int[] cost) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(helper(i+1, cost), helper(i+2, cost));
        return memo[i];
    }
    */

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                             dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    /*
    // [1,2,3,4,5]
    // [1,2,7,4,5]
    // [1,6,7,4,5]
    // [7,6,7,4,5]
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }
    */
}
