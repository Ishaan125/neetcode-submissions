class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> res = new Stack<>();
        res.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] arr1 = res.peek();

            if (arr1[1] >= intervals[i][0]) {
                int[] arr = res.pop();
                arr[1] = Math.max(arr[1], intervals[i][1]);
                res.push(arr);
            }
            else {
                res.push(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
