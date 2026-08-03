class MedianFinder {
    PriorityQueue<Integer> maxHeap; // smaller
    PriorityQueue<Integer> minHeap; // larger

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (!maxHeap.isEmpty() && num > maxHeap.peek()) {
            minHeap.offer(num);
        }
        else {
            maxHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size()+1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        }
        return (double) maxHeap.peek();
    }
}
