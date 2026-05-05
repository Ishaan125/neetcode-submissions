class Solution {
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
        dp[i][j] = res;
        return res;
    }
}
