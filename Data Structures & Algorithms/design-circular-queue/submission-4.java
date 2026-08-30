class ListNode { 
    int val; 
    ListNode next; 
    public ListNode(int x, ListNode next) { 
        this.val = x; 
        this.next = next; 
    } 
}

class MyCircularQueue {
    private int size;
    private int cap;
    private ListNode l;
    private ListNode r;

    public MyCircularQueue(int k) {
        size = 0;
        cap = k;
        l = null;
        r = null;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        ListNode node = new ListNode(value, null);

        if (isEmpty()) {
            l = node;
            r = node;
        } 
        else {
            r.next = node;
            r = r.next;
        }

        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        l = l.next;
        size--;

        if (size == 0) {
            r = null;
        }

        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : l.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : r.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}