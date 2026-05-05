class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, 1, 0, "(", n);
        return res;
    }

    public void helper(List<String> res, int o, int c, String curr, int n) {
        if (curr.length()/2 == n) {
            res.add(curr);
            return;
        }
        if (o < n) {
            curr += "(";
            helper(res, o+1, c, curr, n);
            curr = curr.substring(0,curr.length()-1);
        }
        if (c < o) {
            curr += ")";
            helper(res, o, c+1, curr, n);
            curr = curr.substring(0,curr.length()-1);
        }
    }
}
