class MinStack {
    private Stack<Integer> nums;

    public MinStack() {
        nums = new Stack<>();
    }
    
    public void push(int val) {
        nums.push(val);
    }
    
    public void pop() {
        nums.pop();
    }
    
    public int top() {
        return nums.peek();
    }
    
    public int getMin() {
        Stack<Integer> temp = new Stack<>();
        int min = nums.peek();
        while (!nums.isEmpty()) {
            int tempNum = nums.pop();
            if (tempNum < min) {
                min = tempNum;
            }
            temp.push(tempNum);
        }
        while (!temp.isEmpty()) {
            nums.push(temp.pop());
        }
        return min;
    }
}
