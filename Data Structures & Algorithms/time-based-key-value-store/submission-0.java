class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keys;

    public TimeMap() {
        keys = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> pair = new Pair<>(timestamp, value);
        if (keys.containsKey(key)) {
            keys.get(key).add(pair);
        }
        else {
            keys.put(key, new ArrayList<>(List.of(pair)));
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = 
            keys.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = values.size() - 1;
        String res = "";

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (values.get(m).getKey() <= timestamp) {
                res = values.get(m).getValue();
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return res;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
    }
}
