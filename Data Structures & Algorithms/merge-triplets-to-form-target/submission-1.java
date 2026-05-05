class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] check = new boolean[3];
        for (int[] triple : triplets) {
            if (check[0] && check[1] && check[2]) {
                return true;
            }
            if (triple[0] > target[0] || triple[1] > target[1] ||
                triple[2] > target[2]) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if (triple[i] == target[i]) {
                    check[i] = true;
                }
            }
        }

        return check[0] && check[1] && check[2];
    }
}
