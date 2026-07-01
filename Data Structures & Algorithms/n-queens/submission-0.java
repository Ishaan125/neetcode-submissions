class Solution {
    boolean[] rows;
    boolean[] topL;
    boolean[] bottomL;
    boolean[][] queens;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        rows = new boolean[n];
        queens = new boolean[n][n];
        topL = new boolean[n*2-1];
        bottomL = new boolean[n*2-1];
        res = new ArrayList<>();
        helper(0, n);
        return res;
    }

    private void helper(int col, int n) {
        if (col == n) {
            List<String> curr = new ArrayList<>();
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    text.append(queens[i][j] ? "Q" : ".");
                }
                curr.add(text.toString());
                text.setLength(0);
            }
            res.add(curr);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!rows[i] && !bottomL[i+col] && !topL[i-col+n-1]) {
                rows[i] = true;
                bottomL[i + col] = true;
                topL[i - col + n - 1] = true;
                queens[i][col] = true;
                helper(col+1, n);
                rows[i] = false;
                queens[i][col] = false;
                bottomL[i + col] = false;
                topL[i - col + n - 1] = false;
            }
        }
    }
}
