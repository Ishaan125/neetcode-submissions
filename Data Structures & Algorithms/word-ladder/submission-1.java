class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        LinkedList<String> q = new LinkedList<>();
        q.offer(beginWord);
        boolean[] visited = new boolean[wordList.size()];

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String word = q.poll();
                if (wordList.contains(word)) {
                    visited[wordList.indexOf(word)] = true;
                }
                if (word.equals(endWord)) {
                    return res;
                }

                for (String nei : wordList) {
                    if (!visited[wordList.indexOf(nei)] && check(word, nei)) {
                        q.offer(nei);
                    }
                }
            }
            res++;
        }
        return 0;
    }

    private boolean check(String word1, String word2) {
        int dif = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                dif++;
            }
            if (dif > 1) {
                return false;
            }
        }
        return true;
    }
}
