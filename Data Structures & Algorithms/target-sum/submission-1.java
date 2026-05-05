class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0);
    }

    private int helper(int[] nums, int target, int i) {
        int total = 0;
        if (target == 0 && i == nums.length) {
            return 1;
        }
        if (i >= nums.length) {
            return 0;
        }
        total += helper(nums, target - nums[i], i+1);
        total += helper(nums, target + nums[i], i+1);

        return total;
    }
}
