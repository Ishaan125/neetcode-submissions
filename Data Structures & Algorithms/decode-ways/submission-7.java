class Solution {
    public int numDecodings(String s) {
        int nn = 1;
        int n = 1;
        int curr = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                curr = 0;
            }
            else if (i < s.length() - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) {
                curr = n + nn;
            }
            else {
                curr = n;
            }
            nn = n;
            n = curr;
        }

        return curr;
    }
}
