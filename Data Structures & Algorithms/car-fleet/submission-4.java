class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> times = new Stack<>();
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] p : pair) {
            double num = (double) (target-p[0]) / p[1];
            if (times.isEmpty() || num > times.peek()) {
                times.push(num);
            }  
        }
        return times.size();
    }
}
