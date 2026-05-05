class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> row = new HashMap<>();
        Map<Integer, HashSet<Character>> col = new HashMap<>();
        Map<Integer, HashSet<Character>> square = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int sq = (i/3)*3 + j/3;
                    row.putIfAbsent(i, new HashSet<>());
                    col.putIfAbsent(j, new HashSet<>());
                    square.putIfAbsent(sq, new HashSet<>());
                    if (row.get(i).contains(board[i][j]) || 
                        col.get(j).contains(board[i][j]) || 
                        square.get(sq).contains(board[i][j])) {
                        return false;
                    }
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    square.get(sq).add(board[i][j]);
                }
            }
        }       
        return true;
    }
}
