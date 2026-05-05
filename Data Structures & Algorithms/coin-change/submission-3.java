class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int min = helper(coins, amount);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int helper(int[] coins, int amount) {
        int res = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        for (int i : coins) {
            if (amount - i >= 0) {
                int res2 = helper(coins, amount - i);
                if (res2 != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + res2); 
                } 
            }
        } 

        memo.put(amount, res);
        return res;
    }
}
