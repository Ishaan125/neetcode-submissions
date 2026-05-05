class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }

    private int helper(int[] nums, int target, int l, int r) {
        int m = (l+r)/2;
        if (nums[m] == target) {
            return m;
        }
        if (l >= r) {
            return -1;
        }
        if (target > nums[m]) {
            return helper(nums, target, m+1, r);
        }
        return helper(nums, target, l, m-1);
    }
}
