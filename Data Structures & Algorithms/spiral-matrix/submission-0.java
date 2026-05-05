class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minX = 0, minY = 0;
        int maxX = matrix[0].length - 1;
        int maxY = matrix.length - 1;
        List<Integer> nums = new ArrayList<>();
        while (minY <= maxY && minX <= maxX) {
            for (int i = minX; i <= maxX; i++) {
                nums.add(matrix[minY][i]);
            }
            minY++;
            if (minY > maxY) break;
            for (int i = minY; i <= maxY; i++) {
                nums.add(matrix[i][maxX]);
            }
            maxX--;
            if (minX > maxX) break;
            for (int i = maxX; i >= minX; i--) {
                nums.add(matrix[maxY][i]);
            }
            maxY--;
            if (minY > maxY) break;
            for (int i = maxY; i >= minY; i--) {
                nums.add(matrix[i][minX]);
            }
            minX++;  
        }
        return nums;
    }
}
