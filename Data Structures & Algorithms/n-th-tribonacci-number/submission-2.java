class Solution {
    public int tribonacci(int n) {
        int one = 0;
        int two = 1;
        int three = 1;
        if (n < 3) {
            return n < 2 ? n : 1;
        }
        for (int i = 0; i <= n - 3; i++) {
            int next = one + two + three;
            one = two;
            two = three;
            three = next;
        }
        return three;
    }
}