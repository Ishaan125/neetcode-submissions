class Solution {
    private boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()];
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int i) {
        if (i >= s.length()) {
            return true;
        }
        if (dp[i]) {
            return false;
        }
        for (String word : wordDict) {
            if (s.substring(i).startsWith(word)) {
                if (dfs(s, wordDict, i + word.length())) {
                    return true;
                }
            }
        }
        dp[i] = true;
        return false;
    }
}
