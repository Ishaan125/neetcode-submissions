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
                int check = 1 + dfs(coins, amount - i);
                count = Math.min(count, check);
            }
        }

        memo.put(amount, count);
        return count;
    }
}
