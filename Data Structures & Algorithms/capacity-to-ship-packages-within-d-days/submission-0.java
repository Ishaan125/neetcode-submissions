class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        
        int res = 0;
        while (l <= r) {
            int m = l + (r-l)/2;
            int total = 0;
            int curr = 1;
            boolean valid = true;
            for (int w : weights) {
                if (total + w > m) {
                    total = 0;
                    curr++;
                }
                if (curr > days) {
                    valid = false;
                    break;
                }
                total += w;
            }

            if (valid) {
                res = m;
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return res;
    }
}