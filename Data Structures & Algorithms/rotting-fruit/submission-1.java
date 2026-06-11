class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                else if (grid[i][j] == 2) {
                    rotten.add(new int[]{i,j});
                }
            }
        }

        int minutes = 0;
        while (fresh != 0 && !rotten.isEmpty()) {
            int l = rotten.size();
            for (int i = 0; i < l; i++) {
                int[] arr = rotten.poll();
                if (arr[0] > 0 && grid[arr[0]-1][arr[1]] == 1) {
                    rotten.add(new int[]{arr[0]-1,arr[1]});
                    grid[arr[0]-1][arr[1]] = 2;
                    fresh--;
                }
                if (arr[1] > 0 && grid[arr[0]][arr[1]-1] == 1) {
                    rotten.add(new int[]{arr[0],arr[1]-1});
                    grid[arr[0]][arr[1]-1] = 2;
                    fresh--;
                }
                if (arr[0] < grid.length-1 && grid[arr[0]+1][arr[1]] == 1) {
                    rotten.add(new int[]{arr[0]+1,arr[1]});
                    grid[arr[0]+1][arr[1]] = 2;
                    fresh--;
                }
                if (arr[1] < grid[0].length-1 && grid[arr[0]][arr[1]+1] == 1) {
                    rotten.add(new int[]{arr[0],arr[1]+1});
                    grid[arr[0]][arr[1]+1] = 2;
                    fresh--;
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
