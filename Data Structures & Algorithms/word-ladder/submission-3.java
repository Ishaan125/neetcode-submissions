class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        LinkedList<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return res;
                }

                for (String nei : wordList) {
                    if (!visited.contains(nei) && check(word, nei)) {
                        q.offer(nei);
                        visited.add(nei);
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
