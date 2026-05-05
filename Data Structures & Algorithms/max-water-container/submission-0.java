class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int width = heights.length-1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, width * Math.min(heights[l], heights[r]));
            if (heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
            width--;
        }

        return max;
    }
}
