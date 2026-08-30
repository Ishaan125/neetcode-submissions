class CountSquares {
    private Map<List<Integer>, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> pointList = Arrays.asList(point[0], point[1]);
        points.put(pointList, points.getOrDefault(pointList, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        for (List<Integer> arr : points.keySet()) {
            if (Math.abs(arr.get(0) - point[0]) != Math.abs(arr.get(1) - point[1]) || 
                (arr.get(0) == point[0] && arr.get(1) == point[1])) continue;
            List<Integer> check1 = Arrays.asList(point[0], arr.get(1));
            List<Integer> check2 = Arrays.asList(arr.get(0), point[1]);
            List<Integer> diag = Arrays.asList(arr.get(0), arr.get(1));
            res += points.getOrDefault(diag, 0) * points.getOrDefault(check1, 0) * points.getOrDefault(check2, 0);
        }
        return res;
    }
}
