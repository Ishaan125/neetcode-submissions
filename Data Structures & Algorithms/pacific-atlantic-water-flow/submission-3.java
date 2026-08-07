class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] p = new boolean[r][c];
        boolean[][] a = new boolean[r][c];
        res = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            dfs(heights, 0, i, p, Integer.MIN_VALUE);
            dfs(heights, r-1, i, a, Integer.MIN_VALUE);
        }
        for (int i = 0; i < r; i++) {
            dfs(heights, i, 0, p, Integer.MIN_VALUE);
            dfs(heights, i, c-1, a, Integer.MIN_VALUE);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (p[i][j] && a[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] add, int min) {
        if (i >= 0 && j >= 0 && i < heights.length && j < heights[0].length && heights[i][j] >= min && !add[i][j]) {
            add[i][j] = true;
            dfs(heights, i-1, j, add, heights[i][j]);
            dfs(heights, i+1, j, add, heights[i][j]);
            dfs(heights, i, j+1, add, heights[i][j]);
            dfs(heights, i, j-1, add, heights[i][j]);
        }
    }
}
