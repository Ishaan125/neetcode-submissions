class StockSpanner {
    private Stack<int[]> stocks;
    public StockSpanner() {
        this.stocks = new Stack<>();
    }
    
    public int next(int price) {
        int next = 1;
        while (!stocks.isEmpty() && price >= stocks.peek()[0]) {
            next += stocks.pop()[1];
        }
        stocks.push(new int[]{price, next});
        return next;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 // 100,1 80,1 70,2 60,1  
 // 100,1 80,1, 75,4
 // 100,1 85,6 
