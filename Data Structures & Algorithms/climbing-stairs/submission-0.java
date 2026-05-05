class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        return helper(n, arr);
    }

    private int helper(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }

        arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        return arr[n];
    }
}
