class Solution {
    public int[] countBits(int n) {
        //101,110,111,1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111, 10000
        //0112|1223|12232334|1
        // 2 4 8 16 
        int offset = 1;
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            arr[i] = 1 + arr[i-offset];
        }
        return arr;
    }
}
