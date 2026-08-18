class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for (int i : nums) {
            if (count == 0) {
                num = i;
            }
            count += i == num ? 1 : -1;
        }

        return num;
    }
}