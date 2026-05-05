class Solution {
    /*
    private int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(word1, word2, 0, 0);
    }

    private int helper(String word1, String word2, int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return helper(word1, word2, i+1, j+1);
        }
        int a = Math.min(helper(word1, word2, i, j+1),
            helper(word1, word2, i+1, j)); 
        return dp[i][j] = 1 + Math.min(a, helper(word1, word2, i+1, j+1));
    }
    */

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[n][i] = m - i;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][m] = n - i;
        }
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
                }
            }
        }

        return dp[0][0];
    }
}
