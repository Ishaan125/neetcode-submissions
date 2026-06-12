class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < c; i++) {
            dfs(0, i, board);
            dfs(r-1, i, board);
        }
        for (int j = 0; j < r; j++) {
            dfs(j, 0, board);
            dfs(j, c-1, board);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        int r = board.length;
        int c = board[0].length;
        if (board[i][j] == 'O') {
            board[i][j] = 'V';
            if (i > 0) {
                dfs(i-1, j, board);
            }
            if (j > 0) {
                dfs(i, j-1, board);
            }
            if (i < r-1) {
                dfs(i+1, j, board);
            }
            if (j < c-1) {
                dfs(i, j+1, board);
            }
        }
    }
}
