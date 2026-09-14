class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length; int cols = heights[0].length;
        int[][] maxDifferences = new int[rows][cols];
        for (int[] arr : maxDifferences) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        maxDifferences[0][0] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.offer(new int[]{0, 0, 0}); // maxDiff, r, c
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!heap.isEmpty()) {
            int[] path = heap.poll();
            int currDiff = path[0]; int r = path[1]; int c = path[2];
            if (r == rows - 1 && c == cols - 1) return currDiff;
            if (maxDifferences[r][c] < currDiff) continue;
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR < 0 || newC < 0 || newR >= rows || newC >= cols) continue;
                int newDiff = Math.max(currDiff, Math.abs(heights[r][c] - heights[newR][newC]));
                if (newDiff < maxDifferences[newR][newC]) {
                    maxDifferences[newR][newC] = newDiff;
                    heap.offer(new int[]{maxDifferences[newR][newC], newR, newC});
                }
            }
        }
        return 0;
    }
}