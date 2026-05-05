class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int idx = 0;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                if (nums[l] < min) {
                    min = nums[l];
                    idx = l;
                }
                break;
            }
            int m = (l + r)/2;
            if (nums[m] < min) {
                    min = nums[m];
                    idx = m;
                }
            if (nums[m] >= nums[l]) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        if (target > nums[nums.length-1]) {
            l = 0;
            r = idx - 1;
        }
        else {
            l = idx;
            r = nums.length - 1;
        }

        while (l <= r) {
            int m = (l + r)/2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return -1;
    }
}
