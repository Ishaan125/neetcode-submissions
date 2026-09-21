class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c + "");
            }
            else {
                StringBuilder sub = new StringBuilder();
                while (!(stack.peek().equals("["))) {
                    sub.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder digits = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    digits.insert(0, stack.pop());
                }
                stack.push(sub.toString().repeat(Integer.parseInt(digits.toString())));
            }
        }

        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}

// 2 [ a 3 [ b ]
// 2 [ a bbb ]
// abbbabbb
// c
