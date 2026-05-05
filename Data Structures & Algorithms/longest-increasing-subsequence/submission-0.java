class Solution {
    private int[] cache;
    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length];
        return helper(nums, -1, 0);
    }

    private int helper(int[] nums, int curr, int next) {
        if (next >= nums.length) {
            return 0;
        }

        int max = helper(nums, curr, next+1);

        if (curr == -1 || nums[next] > nums[curr]) {
            max = Math.max(max, 1 + helper(nums, next, next + 1));
        }

        return max;
    }
}
