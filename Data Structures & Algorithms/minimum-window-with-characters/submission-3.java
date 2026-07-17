class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        String res = "";
        int max = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) {
            count.put(c, 1 + count.getOrDefault(c, 0));
        }
        int need = count.size();

        for (int r = 0; r < s.length(); r++) {
            char let = s.charAt(r);
            window.put(let, 1 + window.getOrDefault(let, 0));
            if (count.containsKey(let) &&
                window.get(let) == count.get(let)) {
                need--;
            }
            while (need == 0) {
                if (r - l + 1 < max) {
                    res = s.substring(l, r + 1);
                    max = res.length();
                }
                char let2 = s.charAt(l);
                window.put(let2, window.get(let2) - 1);
                if (count.containsKey(let2) &&
                    window.get(let2) < count.get(let2)) {
                    need++;
                }
                l++;
            }
        }

        return res;
    }
}