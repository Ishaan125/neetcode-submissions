class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (char c : s1.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : s2.substring(0, s1.length()).toCharArray()) {
            chars[c - 'a']--;
        }

        int ind = 0;
        while(ind + s1.length() < s2.length()) {
            if (zeroes(chars)) {
                return true;
            }
            chars[s2.charAt(ind) - 'a']++;
            chars[s2.charAt(ind + s1.length()) - 'a']--;
            ind++;
        }
        return zeroes(chars);
    }

    private boolean zeroes(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
