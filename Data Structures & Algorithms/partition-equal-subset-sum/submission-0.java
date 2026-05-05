class Solution {
    private Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        dp = new Boolean[nums.length][sum / 2 + 1];

        return helper(nums, sum / 2, 0);
    }

    private boolean helper(int[] nums, int sum, int i)  {
        if (i >= nums.length || sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        return dp[i][sum] = helper(nums, sum - nums[i], i+1) || helper(nums, sum, i+1);
    }
}
