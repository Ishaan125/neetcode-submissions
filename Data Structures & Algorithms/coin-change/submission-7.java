class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int val = dfs(coins, amount);
        return val >= 1000000 ? -1 : val;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int count = Integer.MAX_VALUE - 100;
        for (int i : coins) {
            if (amount - i >= 0) {
                int check = dfs(coins, amount - i);
                if (check < count) {
                    count = Math.min(count, 1 + check);
                }
            }
        }

        memo.put(amount, count);
        return count;
    }
}
