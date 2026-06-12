class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] p = new boolean[r][c];
        boolean[][] a = new boolean[r][c];
        for (int i = 0; i < c; i++) {
            p[0][i] = true;
            dfs(0, i, p, heights);
            a[r-1][i] = true;
            dfs(r-1, i, a, heights);
        }
        for (int j = 0; j < r; j++) {
            p[j][0] = true;
            dfs(j, 0, p, heights);
            a[j][c-1] = true;
            dfs(j, c-1, a, heights);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (p[i][j] && a[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }
        return ret;
    }

    private void dfs(int i, int j, boolean[][] arr, int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        if (i < r-1 && !arr[i+1][j] && heights[i+1][j] >= heights[i][j]) {
            arr[i+1][j] = true;
            dfs(i+1, j, arr, heights);
        }
        if (j < c-1 && !arr[i][j+1] && heights[i][j+1] >= heights[i][j]) {
            arr[i][j+1] = true;
            dfs(i, j+1, arr, heights);
        }
        if (i > 0 && !arr[i-1][j] && heights[i-1][j] >= heights[i][j]) {
            arr[i-1][j] = true;
            dfs(i-1, j, arr, heights);
        }
        if (j > 0 && !arr[i][j-1] && heights[i][j-1] >= heights[i][j]) {
            arr[i][j-1] = true;
            dfs(i, j-1, arr, heights);
        }
    }
}
