class Solution {
    private Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean firstMatch = i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (dfs(s, p, i, j + 2)) {
                return memo[i][j] = true;
            }
            if (firstMatch && dfs(s, p, i + 1, j)) {
                return memo[i][j] = true;
            }
            return memo[i][j] = false;
        }

        if (firstMatch) {
            return memo[i][j] = dfs(s, p, i + 1, j + 1);
        }

        return memo[i][j] = false;
    }
}