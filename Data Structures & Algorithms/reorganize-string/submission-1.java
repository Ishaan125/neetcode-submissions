class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            res.append((char) curr[0]);
            curr[1]--;

            if (prev != null && prev[1] > 0) {
                heap.offer(prev);
            }
            prev = curr;
        }

        return res.length() == s.length() ? res.toString() : "";
    }
}