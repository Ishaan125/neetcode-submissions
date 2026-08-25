class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE, currMax = 0;
        int min = 0, currMin = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
            currMax = Math.max(currMax + num, num);
            currMin = Math.min(currMin + num, num);
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }
}


// 1 -2 3 4 5
// global max = 3 4 5
// total - global min = 1+3+4+5 -2