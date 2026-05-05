class Solution {
    public int search(int[] nums, int target) {
        for (int i = nums.length/2; i < nums.length; i++) {
            if (nums[i]==target) {
                return i;
            }
        }
        if (nums.length == 1) {
            return -1;
        }
        return search(Arrays.copyOfRange(nums, 0, nums.length/2), target);
    }
}
