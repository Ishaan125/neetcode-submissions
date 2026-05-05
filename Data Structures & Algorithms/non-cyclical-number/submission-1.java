class Solution {
    /*
    private Set<Integer> nums;
    public boolean isHappy(int n) {
        nums = new HashSet<>();
        return helper(n);
    }

    private boolean helper(int n) {
        int total = 0;
        for (char c : Integer.toString(n).toCharArray()) {
            total += Math.pow(Integer.parseInt(c+""),2);
        }
        if (total == 1) {
            return true;
        }
        if (nums.contains(total)) {
            return false;
        }
        nums.add(total);
        return helper(total);
    }
    */

    public boolean isHappy(int n) {
        int slow = n;
        int fast = squares(n);
        while (slow != fast) {
            slow = squares(slow);
            fast = squares(squares(fast));
        }
        return slow == 1;
    }

    private int squares(int n) {
        int total = 0;
        while (n > 0) {
            total += Math.pow(n%10, 2);
            n /= 10;
        }
        return total;
    }
}
