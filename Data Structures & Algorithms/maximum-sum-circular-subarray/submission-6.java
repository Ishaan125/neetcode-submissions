class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = 0, currMax = 0;
        int min = 0, currMin = 0;
        int total = 0;
        boolean positive = false;
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0) {
                positive = true;
            }
            largest = Math.max(largest, num);
            total += num;
            currMax += num;
            currMin += num;
            if (currMax < 0) {
                currMax = 0;
            }
            if (currMin > 0) {
                currMin = 0;
            }
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
        }

        return positive ? Math.max(max, total - min) : largest;
    }
}


// 1 -2 3 4 5
// global max = 3 4 5
// total - global min = 1+3+4+5 -2