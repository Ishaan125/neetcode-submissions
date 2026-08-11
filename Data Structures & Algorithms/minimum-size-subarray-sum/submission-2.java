class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int curr = 0;
        while (r < nums.length) {
            curr += nums[r];
            while (curr >= target) {
                min = Math.min(min, r - l + 1);
                curr -= nums[l];
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}