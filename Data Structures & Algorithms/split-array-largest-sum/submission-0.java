class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int num : nums) {
            r += num;
            l = Math.max(l, num);
        }

        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r-l) / 2;
            int subs = 1;
            int curr = 0;
            for (int num : nums) {
                if (curr + num > m) {
                    subs++;
                    curr = 0;
                }
                curr += num;
            }
            if (subs <= k) {
                res = Math.min(res, m);
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return res;
    }
}

// get sum of array
// l = largest elem, r = sum
