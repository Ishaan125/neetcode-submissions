class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                int temp2 = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp2;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r = matrix[0].length-1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}

// 0,1 > 1,0   0,2 > 2,0    1,2 > 2,1