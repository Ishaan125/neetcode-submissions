class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] lets = new int[26];
        for (int i = 0; i < order.length(); i++) {
            lets[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i+1].length()) {
                    return false;
                }
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    if (lets[words[i].charAt(j)-'a'] > lets[words[i+1].charAt(j)-'a']) {
                        return false;
                    }
                    break;
                }
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

