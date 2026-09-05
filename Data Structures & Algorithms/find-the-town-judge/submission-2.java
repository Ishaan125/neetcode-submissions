class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] find = new int[n + 1];
        for (int[] arr : trust) {
            find[arr[0]]--;
            find[arr[1]]++;
        }
        for (int i = 0; i < find.length; i++) {
            if (find[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}

// [0,0,0] -> [0,-1,0] -> [0,-1,1]