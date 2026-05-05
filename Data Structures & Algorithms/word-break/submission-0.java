class Solution {
    private boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new boolean[s.length()];
        return helper(s, wordDict, 0);
    }
    public boolean helper(String s, List<String> wordDict, int i) {
        if (i >= s.length()) {
            return true;
        }
        if (cache[i]) {
            return false;
        }
        
        for (String word : wordDict) {
            if (s.substring(i).startsWith(word)) {
                if (helper(s, wordDict, i + word.length())) {
                    return true;
                }
            }
        }

        cache[i] = true;
        return false;
    }
}
