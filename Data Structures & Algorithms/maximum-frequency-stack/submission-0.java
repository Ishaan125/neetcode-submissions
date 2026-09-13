class FreqStack {
    private List<Stack<Integer>> stacks;
    private Map<Integer, Integer> freq;

    public FreqStack() {
        stacks = new ArrayList<>();
        freq = new HashMap<>();
        stacks.add(new Stack<>());
    }
    
    public void push(int val) {
        int count = freq.getOrDefault(val, 0) + 1;
        freq.put(val, count);
        if (count == stacks.size()) {
            stacks.add(new Stack<>());
        }
        stacks.get(count).push(val);
    }
    
    public int pop() {
        int val = stacks.get(stacks.size() - 1).pop();
        freq.put(val, freq.get(val) - 1);
        if (stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */