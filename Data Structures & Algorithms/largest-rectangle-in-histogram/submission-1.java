class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int left = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left = stack.peek();
            }
            stack.push(i);
            max = Math.max(max, heights[i] * (right[i] - left - 1));
        }
        return max;
    }
}


// brute: O(n^2)
// -1, -1, 1, 1, 1, 4
// 1, -1, 3, -1, -1, -1
