class Solution {
    private int[] sides;
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        int max = 0;
        for (int i : matchsticks) {
            max = Math.max(max, i);
            total += i;
        }
        if (total % 4 != 0 || max > total/4) {
            return false;
        }

        sides = new int[4];
        return dfs(matchsticks, 0, total);
    }

    private boolean dfs(int[] matchsticks, int curr, int total) {
        if (curr >= matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[curr] <= total/4) {
                sides[i] += matchsticks[curr];
                if (dfs(matchsticks, curr+1, total)) {
                    return true;
                }
                sides[i] -= matchsticks[curr];
            }
        }
        return false;
    }
}