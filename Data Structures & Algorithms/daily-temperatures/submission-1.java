class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> nums = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!nums.isEmpty() && temperatures[i] > nums.peek()[0]) {
                int[] pair = nums.pop();
                res[pair[1]] = i - pair[1];
            }
            nums.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
