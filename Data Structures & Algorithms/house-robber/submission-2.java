class Solution {
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
}