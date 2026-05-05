class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int i : piles) {
            if (i > r) {
                r = i;
            }
        }

        int best = r;
        while (l <= r) {
            int total = 0;
            int m = (l+r)/2;

            for (int i : piles) {
                total += Math.ceil((double) i/m);
            }

            if (total <= h) {
                best = m;
                r = m - 1;
            }
            else if (total > h) {
                l = m + 1;
            }
        }

        return best;
    }
}
