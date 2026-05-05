class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num = new HashSet<>();
        for (int i : nums) {
            num.add(i);
        }
        int max = 0;
        for (int i : num) {
            if (!num.contains(i-1)) {
                int length = 1;
                while (num.contains(i+length)) {
                    length++;
                }
                max = Math.max(max, length); 
            }  
        }
        return max;
    }
}
