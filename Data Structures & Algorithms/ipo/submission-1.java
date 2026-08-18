class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);

        for (int i = 0; i < capital.length; i++) {
            min.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!min.isEmpty() && min.peek()[0] <= w) {
                max.offer(min.poll()[1]);
            }
            if (max.isEmpty()) break;
            w += max.poll();
        }

        return w;
    }
}

// minheap of arrays to store smallest capitals with their profits
// add everything to minHeap
// add any viable capital's profit to profit maxHeap
// poll one from maxHeap every iteration until k