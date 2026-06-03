class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            if (i > 0) {
                heap.offer(i);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>(); 

        while (!heap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!heap.isEmpty()) {
                int count = heap.poll();
                if (count - 1 > 0) {
                    q.add(new int[]{count - 1, time + n});
                }
            }
            
            if (!q.isEmpty() && q.peek()[1] == time) {
                heap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
