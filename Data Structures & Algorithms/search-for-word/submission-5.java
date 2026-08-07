class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][]board, String word, int curr) {
        if (curr == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (!visited[i][j] && board[i][j] == word.charAt(curr)) {
            curr++;
            visited[i][j] = true;
            if (dfs(i+1, j, board, word, curr) || dfs(i-1, j, board, word, curr)
                || dfs(i, j+1, board, word, curr) || dfs(i, j-1, board, word, curr)) {
                return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
