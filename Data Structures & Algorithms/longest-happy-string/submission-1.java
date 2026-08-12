class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(x -> -x[0]));
        StringBuilder str = new StringBuilder();
        if (a > 0) heap.offer(new int[]{a, 'a'});
        if (b > 0) heap.offer(new int[]{b, 'b'});
        if (c > 0) heap.offer(new int[]{c, 'c'});

        while (!heap.isEmpty()) {
            int[] first = heap.poll();
            if (str.length() >= 2 && str.charAt(str.length()-2) == 
                str.charAt(str.length()-1) && str.charAt(str.length()-1) == first[1]) {
                if (heap.isEmpty()) {
                    break;
                }
                int[] second = heap.poll();
                second[0]--;
                str.append((char) second[1]);
                if (second[0] > 0){
                    heap.offer(second);
                }
                heap.offer(first);
            }
            else {
                first[0]--;
                str.append((char) first[1]);
                if (first[0] > 0){
                    heap.offer(first);
                }
            }
        }
        return str.toString();
    }
}