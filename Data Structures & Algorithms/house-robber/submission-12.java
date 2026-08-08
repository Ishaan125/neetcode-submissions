class Solution {
    private int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        return cache[i] = Math.max(nums[i] + dfs(nums, i+2), dfs(nums, i+1));
    }
}
