class Solution {
    private int[][] cache;
    public int numDistinct(String s, String t) {
        cache = new int[s.length()][t.length()];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if (j >= t.length()) {
            return 1;
        }
        if (i >= s.length()) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int curr = dfs(s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j)) {
            curr += dfs(s, t, i + 1, j + 1);
        }
        return cache[i][j] = curr;
    }
}
