class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        } // enqueue, processing, index
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> 
            a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
            //sort processing first, then index

        int currTime = tasks[0][0];
        int i = 0;
        int[] res = new int[n];
        int idx = 0;
        while (idx < n) {
            while (i < n && currTime >= tasks[i][0]) {
                heap.offer(tasks[i]);
                i++;
            }
            int[] task = heap.poll();
            res[idx] = task[2];
            currTime += task[1];
            idx++;
            if (i < n) {
                currTime = Math.max(currTime, tasks[i][0]);
            }
        }

        return res;
    }
}