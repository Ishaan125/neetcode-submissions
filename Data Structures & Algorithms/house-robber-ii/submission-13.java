class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int pp = 0;
        int p = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int curr = Math.max(nums[i]+pp, p);
            pp = p;
            p = curr;
        }

        int pp2 = 0;
        int p2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int curr2 = Math.max(nums[i]+pp2, p2);
            pp2 = p2;
            p2 = curr2;
        }

        return Math.max(p, p2);
    }
}
