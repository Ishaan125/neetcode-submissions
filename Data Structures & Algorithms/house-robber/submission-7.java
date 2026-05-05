class Solution {
    /*
    private int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length + 1];
        Arrays.fill(cache, -1);
        return helper(nums, 0);
    }
    
    private int helper(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        cache[i] = Math.max(nums[i] + helper(nums, i+2), helper(nums, i+1));
        return cache[i];
    }
    */

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[nums.length - 1];
    }
}