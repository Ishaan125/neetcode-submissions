class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> count = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
            
            String key = Arrays.toString(arr);
            count.putIfAbsent(key, new ArrayList<>());
            count.get(key).add(s);
        }

        return new ArrayList<>(count.values());
    }
}
