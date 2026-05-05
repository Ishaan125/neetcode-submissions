class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumG = 0;
        int sumC = 0;
        for (int num : gas)  {
            sumG += num;
        }
        for (int num : cost)  {
            sumC += num;
        }

        if (sumC > sumG) {
            return -1;
        }

        int total = 0;
        int ind = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                ind = i + 1;
            }
        }

        return ind;
    }
}
