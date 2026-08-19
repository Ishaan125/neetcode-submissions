class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] lets = new int[26];
        for (int i = 0; i < order.length(); i++)
            lets[order.charAt(i) - 'a'] = i;

        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            while (j < Math.min(words[i].length(), words[i+1].length()) && words[i].charAt(j) == words[i+1].charAt(j)) {
                j++;
            }
            if (j >= words[i+1].length() || (j < words[i].length() && lets[words[i].charAt(j)-'a'] > lets[words[i+1].charAt(j)-'a'])) {
                return false;
            }
        }
        return true;
    }
}
// u ul
// dags dagts
// dagst dag
// dagst dfg
// dags dagt

