class Solution {
    public boolean isAnagram(String s, String t) {
        int[] let = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            let[s.charAt(i) - 'a']++;
            let[t.charAt(i) - 'a']--;
        }

        for (int i : let) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
