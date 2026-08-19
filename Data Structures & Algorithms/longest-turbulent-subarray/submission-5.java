class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                dp[i][1] = dp[i + 1][0] + 1;
                res = Math.max(res, dp[i][1]);
            }
            else if (arr[i] > arr[i + 1]) {
                dp[i][0] = dp[i + 1][1] + 1;
                res = Math.max(res, dp[i][0]);
            }
        } 
        return res;
    }
}

// index i holds start index and maps to length and sign