class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, PriorityQueue<int[]>> tweetMap;

    public Twitter() {
        this.time = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new PriorityQueue<>((a, b) -> b[0] - a[0]));
        }
        tweetMap.get(userId).add(new int[]{time++, tweetId});
        follow(userId, userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        List<Integer> res = new ArrayList<>();
        if (followMap.get(userId) == null) {
            return res;
        }
        for (int followee : followMap.get(userId)) {
            for (int[] tweet : tweetMap.get(followee)) {
                q.offer(tweet);
            }
        }
        for (int i = 0; i < 10 && !q.isEmpty(); i++) {
            res.add(q.poll()[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followMap.get(followerId) == null) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && followMap.get(followerId) != null) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
