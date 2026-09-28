class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String cur : path.split("/")) {
            if (cur.equals("")) continue;
            if (cur.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else if (!cur.equals(".")) {
                stack.push(cur);
            }
        }
        return "/" + String.join("/", stack);
    }
}

// / net / prac / ... / ..
// / net / prac / courses
