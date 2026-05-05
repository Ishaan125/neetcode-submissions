class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                brackets.push(i);
            }
            else {
                if (brackets.isEmpty()) {
                    return false;
                }
                char top = brackets.pop();
                if (i == ')' && top != '(' || 
                i == ']' && top != '[' || i == '}' && top != '{') {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
