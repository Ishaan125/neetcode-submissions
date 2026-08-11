class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int pass = 0;

        for (int[] trip : trips) {
            pass += trip[0];
            while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) {
                pass -= heap.poll()[0];
            }
            if (pass > capacity) {
                return false;
            }
            heap.offer(trip);
        }
        return true;
    }
}