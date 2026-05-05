/* class Solution {
    public boolean exist(char[][] board, String word) {
        String curr = "";
        boolean[][] picked = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                curr = board[i][j] + "";
                picked[i][j] = true;
                if (helper(board, word, curr, i, j, picked)) {
                    return true;
                }
                picked[i][j] = false;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, String curr, int i, int j, boolean[][] picked) {
        if (curr.equals(word)) {
            return true;
        }
        if (i >= board.length || j >= board[0].length) {
            return false;
        }

        if ((i >= 1 && picked[i-1][j]) || (j >= 1 && picked[i][j-1])) {
            curr += board[i][j];
            picked[i][j] = true;
            if (helper(board, word, curr, i+1, j, picked) || helper(board, word, curr, i, j+1, picked)) {
                return true;
            }
            curr = curr.substring(0, curr.length()-1);
            picked[i][j] = false;
        }

        if (helper(board, word, curr, i+1, j, picked) || helper(board, word, curr, i, j+1, picked)) {
            return true;
        }
        return false;
    }
} */

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        // If we've matched all characters
        if (idx == word.length()) return true;

        // Bounds + character mismatch + visited check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (visited[i][j] || board[i][j] != word.charAt(idx)) return false;

        // Mark
        visited[i][j] = true;

        // Explore 4 directions
        boolean found =
            dfs(board, word, idx + 1, i + 1, j, visited) ||
            dfs(board, word, idx + 1, i - 1, j, visited) ||
            dfs(board, word, idx + 1, i, j + 1, visited) ||
            dfs(board, word, idx + 1, i, j - 1, visited);

        // Unmark (backtracking)
        visited[i][j] = false;

        return found;
    }
}

