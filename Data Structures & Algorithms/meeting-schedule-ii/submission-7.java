/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        intervals.sort((a, b) -> a.start - b.start);
        int res = 0;
        int count = 0;
        for (Interval meet : intervals) {
            while (heap.size() > 0 && heap.peek() <= meet.start) {
                heap.poll();
                count--;
            }
            heap.offer(meet.end);
            count++;
            res = Math.max(res, count);
        }

        return res;
    }
}
