class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k  + 1];
        int l = 0; int r = 0; int i = 0;

        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offerLast(r);
            if (r >= k - 1) {
                if (q.peekFirst() < l) {
                    q.pollFirst();
                }
                res[i] = nums[q.peekFirst()];
                i++;
                l++;
            }
            r++;
        }
        return res;
    }
}