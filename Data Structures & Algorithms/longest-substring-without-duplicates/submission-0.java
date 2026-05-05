class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        Set<Character> chars = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            if (!chars.contains(s.charAt(r))) {
                chars.add(s.charAt(r));
                max = Math.max(max, r-l+1);
            }
            else {
                chars.remove(s.charAt(l));
                l++;
                r--;
            }
        }
        return max;
    }
}
