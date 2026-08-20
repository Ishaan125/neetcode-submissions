class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] arr : flights) {
                if (prices[arr[0]] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[arr[0]] + arr[2] < temp[arr[1]]) {
                    temp[arr[1]] = prices[arr[0]] + arr[2];
                }
            }
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}

// [0, inf, inf...]
// 