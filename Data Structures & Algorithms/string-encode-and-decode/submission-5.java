class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            result.append(strs.get(i).length() + "#" + strs.get(i));
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            res.add(str.substring(j+1, j+1+length));
            i = j + length + 1;
        }
        return res;
    }
}
