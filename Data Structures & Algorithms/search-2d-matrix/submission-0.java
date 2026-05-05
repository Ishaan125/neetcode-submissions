class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while (l <= r) {
            int m = (l+r)/2;
            int col = m % matrix[0].length;
            int row = (m) / matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return false;
    }
}
