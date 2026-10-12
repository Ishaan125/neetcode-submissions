class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);
            max = Math.max(max, count.get(c));
            while (r - l + 1 - max > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
