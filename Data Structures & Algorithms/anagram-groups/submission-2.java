class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> words = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String word = new String(arr);
            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(str);
        }

        return new ArrayList<>(words.values());
    }
}
