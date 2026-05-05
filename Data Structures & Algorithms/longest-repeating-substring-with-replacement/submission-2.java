class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> chars = new HashSet<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            chars.add(c);
        }

        for (char c : chars) {
            int l = 0;
            int cnt = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    cnt++;
                }
                if (r - l + 1 - cnt > k) {
                    while (s.charAt(l) == c) {
                        l++;
                        cnt--;
                    }
                    l++;
                }
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}
