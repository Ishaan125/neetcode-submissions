class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = 1;
        int[] suf = new int[nums.length];
        suf[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i-1] * pre[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            suf[i] = nums[i+1] * suf[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pre[i] * suf[i];
        }
        return nums;
    }
}  