class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : hand) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }

        Arrays.sort(hand);
        for (int num : hand) {
            if (counts.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (counts.getOrDefault(i, 0) == 0) {
                        return false;
                    }

                    counts.put(i, counts.get(i) - 1);
                }
            }
        }

        return true;
    }
}
