class Solution {
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
}
