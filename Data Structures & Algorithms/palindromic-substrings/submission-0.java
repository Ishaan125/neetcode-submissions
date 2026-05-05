class Solution {
    public int countSubstrings(String s) {
        int total = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    total++;
                    dp[i][j] = true;
                }
            }
        }
        return total;
    }
}
