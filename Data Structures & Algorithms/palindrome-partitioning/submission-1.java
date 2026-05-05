class Solution {

    private List<List<String>> res = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(0, 0, s);
        return res;
    }

    private void helper(int left, int right, String s) {      
        if (right >= s.length()) {
            if (left == right) {
                res.add(new ArrayList<>(part));
            }
        }
        
        else {
            if (pali(s, left, right)) {
                part.add(s.substring(left, right + 1));
                helper(right + 1, right + 1, s);
                part.remove(part.size() - 1);
            }
            helper(left, right + 1, s);
        }
    }

    private boolean pali(String s, int left, int right) {
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
