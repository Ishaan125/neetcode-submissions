class Solution {
    public int[] productExceptSelf(int[] nums) {
        int k = nums.length;
        int[] pre = new int[k];
        pre[0] = 1;
        int[] suf = new int[k];
        suf[k-1] = 1;
        for (int i = 1; i < k; i++) {
            pre[i] = nums[i-1]*pre[i-1];
        }
        for (int i = k - 2; i >= 0; i--) {
            suf[i] = nums[i+1]*suf[i+1];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = pre[i]*suf[i];
        }
        return nums;
    }
}  
