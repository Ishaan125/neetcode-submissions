class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(word.toCharArray(), curr, 0);
    }

    private boolean dfs(char[] word, TrieNode curr, int idx) {
        for (int i = idx; i < word.length; i++) {
            if (word[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null) {
                        if (dfs(word, curr.children[j], i+1)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else if (curr.children[word[i]-'a'] == null) {
                return false;
            }
            curr = curr.children[word[i]-'a'];
        }
        return curr.end;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean end;
    public TrieNode() {
        this.children = new TrieNode[26];
        this.end = false;
    }
}