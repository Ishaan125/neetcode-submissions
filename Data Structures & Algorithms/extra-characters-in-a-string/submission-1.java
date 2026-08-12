class Solution {
    private int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        Set<String> words = new HashSet<>();
        for (String word : dictionary) {
            words.add(word);
        }
        return dfs(0, s, words);
    }

    private int dfs(int i, String s, Set<String> words) {
        if (i >= s.length()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int substrings = 1 + dfs(i + 1, s, words);
        for (int j = i; j < s.length(); j++) {
            if (words.contains(s.substring(i, j+1))) {
                substrings = Math.min(substrings, dfs(j + 1, s, words));
            }
        }

        return dp[i] = substrings;
    }
}