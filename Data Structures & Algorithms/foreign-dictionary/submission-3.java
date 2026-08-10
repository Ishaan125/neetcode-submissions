class Solution {
    private Map<Character, Set<Character>> adj;
    private Map<Character, Integer> state;
    private StringBuilder result;

    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();

        // Add every character to the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int minLen = Math.min(first.length(), second.length());
            int j = 0;

            // Find first different character
            while (j < minLen && first.charAt(j) == second.charAt(j)) {
                j++;
            }

            // Invalid case: ["abc", "ab"]
            if (j == minLen && first.length() > second.length()) {
                return "";
            }

            // First differing character gives an ordering
            if (j < minLen) {
                char before = first.charAt(j);
                char after = second.charAt(j);

                adj.get(before).add(after);
            }
        }

        state = new HashMap<>();
        result = new StringBuilder();

        // DFS every character
        for (char c : adj.keySet()) {
            if (!dfs(c)) {
                return "";
            }
        }

        return result.reverse().toString();
    }

    private boolean dfs(char curr) {
        // Currently visiting -> cycle
        if (state.getOrDefault(curr, 0) == 1) {
            return false;
        }

        // Already processed
        if (state.getOrDefault(curr, 0) == 2) {
            return true;
        }

        // Mark as currently visiting
        state.put(curr, 1);

        for (char next : adj.get(curr)) {
            if (!dfs(next)) {
                return false;
            }
        }

        // Completely processed
        state.put(curr, 2);

        result.append(curr);

        return true;
    }
}