class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { 
                int[] arr = q.remove();
                int x = arr[0];
                int y = arr[1];
                if (grid[x][y] == 2147483647) {
                    grid[x][y] = dist;
                }

                if (x > 0 && !visited[x-1][y]) {
                    q.add(new int[]{x-1, y});
                    visited[x-1][y] = true;
                }
                if (y > 0 && !visited[x][y-1]) {
                    q.add(new int[]{x, y-1});
                    visited[x][y-1] = true;
                }
                if (x < grid.length - 1 && !visited[x+1][y]) {
                    q.add(new int[]{x+1, y});
                    visited[x+1][y] = true;
                }
                if (y < grid[0].length - 1 && !visited[x][y+1]) {
                    q.add(new int[]{x, y+1});
                    visited[x][y+1] = true;
                }
            }

            dist++;
        }
    }
}
