class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length - 1) {
            int max = 0;
            for (int i = l; i <= r; i++) {
                max = Math.max(max, i + nums[i]);
            }
            l = r + 1;
            r = max;
            res++;
        }
        return res;
    }
}
