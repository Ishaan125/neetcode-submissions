class MyCircularQueue {
    private List<Integer> q;
    private int cap;
    public MyCircularQueue(int k) {
        this.q = new ArrayList<>();
        this.cap = k;
    }   
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        q.add(value);
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        q.remove(0);
        return true;
    }
    
    public int Front() {
        return !isEmpty() ? q.get(0) : -1;
    }
    
    public int Rear() {
        return !isEmpty() ? q.get(q.size() - 1) : -1;
    }
    
    public boolean isEmpty() {
        return q.size() == 0;
    }
    
    public boolean isFull() {
        return q.size() == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */