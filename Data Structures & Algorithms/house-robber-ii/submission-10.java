class Solution {
    /*
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] cache = new int[nums.length];
        int[] cache2 = new int[nums.length-1];
        Arrays.fill(cache, -1);
        Arrays.fill(cache2, -1);
        return Math.max(helper(nums, 1, false, cache), helper(nums, 0, true, cache2));
    }

    private int helper(int[] nums, int i, boolean flag, int[] memo) {
        if (i == nums.length - 1 && flag) {
            return 0;
        }
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(nums[i] + helper(nums, i+2, flag, memo), helper(nums, i+1, flag, memo));
        return memo[i];
    } 
    */

    /*
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), 
            helper(Arrays.copyOfRange(nums, 0, nums.length-1)));
    }
    
    private int helper(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
    */

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), 
            helper(Arrays.copyOfRange(nums, 0, nums.length-1)));
    }

    private int helper(int[] nums) {
        int prevPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = curr;
        }
        return prev;
    }
}
