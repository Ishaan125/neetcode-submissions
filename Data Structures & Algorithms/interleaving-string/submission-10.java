class Solution {
    /*
    private Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        return helper(0, 0, 0, s1, s2, s3);
    }

    private boolean helper(int i, int j, int k, String s1, String s2, String s3) {
        if (k >= s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (helper(i+1, j, k+1, s1, s2, s3)) {
                res = true;
            }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (helper(i, j+1, k+1, s1, s2, s3)) {
                res = true;
            }
        }
        return dp[i][j] = res;
    }
    */

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m && s1.charAt(i) == s3.charAt(i+j) && dp[i+1][j]) {
                    dp[i][j] = true;
                }
                if (j < n && s2.charAt(j) == s3.charAt(i+j) && dp[i][j+1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }
}
