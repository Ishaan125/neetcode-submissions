class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int ind = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                ind = i + 1;
            }
        }

        return sum >= 0 ? ind : -1;
    }
}
