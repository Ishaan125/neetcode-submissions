class Solution {
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
}
