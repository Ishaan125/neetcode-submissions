class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : stones) {
            heap.offer(-i);
        }

        while (heap.size() > 1) {
            int highest = heap.poll();
            int second = heap.poll();
            if (highest != second) {
                heap.offer(highest - second);
            }
        }

        return heap.size() == 0 ? 0 : Math.abs(heap.peek());
    }
}
