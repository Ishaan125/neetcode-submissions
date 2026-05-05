class Solution {
    /*
    private int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i >= s.length()) {
            return 1;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (i < s.length() - 1) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' && 
                s.charAt(i+1) < '7') {
                return dp[i] = dfs(s, i + 1) + dfs(s, i + 2);
            }
        }
        return dp[i] = dfs(s, i+1);
    }
    */

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            }
            else {
                dp[i] = dp[i+1];
                if (i < s.length() - 1) {
                    if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7') {
                        dp[i] += dp[i+2];
                    }
                }
            }
        }
        return dp[0];
    }
}
