class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(nums[i], currMax * nums[i]);
            currMax = Math.max(currMax, currMin * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);
            currMin = Math.min(currMin, temp * nums[i]);
            max = Math.max(max, currMax);
        }

        return max;
    }
}
