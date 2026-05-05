class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }

        List<Integer> part = new ArrayList<>();
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, last.get(s.charAt(i)));
            if (i == end) {
                part.add(size);
                size = 0;
            }
        }

        return part;
    }
}
