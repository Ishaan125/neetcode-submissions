class Solution {
    private int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(0, true, prices);
    }

    private int helper(int i, boolean buying, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        if (buying) {
            if (dp[i][0] != -1) {
                return dp[i][0];
            }
        }
        else {
            if (dp[i][1] != -1) {
                return dp[i][1];
            }
        }

        int skip = helper(i+1, buying, prices);
        if (buying) {
            return dp[i][0] = Math.max(skip, helper(i+1, false, prices) - prices[i]);
        }
        return dp[i][1] = Math.max(skip, helper(i+2, true, prices) + prices[i]);
    }
}
