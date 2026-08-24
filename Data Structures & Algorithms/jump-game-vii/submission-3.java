class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] reachable = new boolean[s.length()];
        if (s.charAt(s.length()-1) == '1') return false;
        reachable[s.length()-1] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (reachable[i]) {
                for (int j = i - minJump; j >= i - maxJump; j--) {
                    if (j >= 0 && s.charAt(j) == '0') {
                        reachable[j] = true;
                    }
                }
            }
        }
        return reachable[0];
    }
}