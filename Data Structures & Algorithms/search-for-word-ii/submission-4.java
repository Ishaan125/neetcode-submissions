class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.add(word);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) { 
                dfs(root, board, res, i, j, "", new boolean[board.length][board[0].length]);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(TrieNode curr, char[][] board, Set<String> res, int i, int j, String word, boolean[][] visited) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && curr.children[board[i][j]-'a'] != null && !visited[i][j]) {
            curr = curr.children[board[i][j]-'a'];
            word = word + board[i][j];
            visited[i][j] = true;

            if (curr.end) {
                res.add(word);
            }
            dfs(curr, board, res, i+1, j, word, visited);
            dfs(curr, board, res, i-1, j, word, visited);
            dfs(curr, board, res, i, j+1, word, visited);
            dfs(curr, board, res, i, j-1, word, visited);
            visited[i][j] = false;
        }
    }
}

class TrieNode {
    TrieNode[] children;
    boolean end;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.end = false;
    }

    public void add(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.end = true;
    }
}
