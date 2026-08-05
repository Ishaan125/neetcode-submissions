class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            heap.offer(i);
        }

        int max = 0;
        int curr = 0;
        int prev = Integer.MAX_VALUE;
        while (!heap.isEmpty()) {
            int val = heap.poll();
            if (val == prev) {
                continue;
            }
            if (val == prev+1) {
                curr++;
            } 
            else {
                curr = 1;
            }
            prev = val;
            max = Math.max(max, curr);
        }
        return max;
    }
}
