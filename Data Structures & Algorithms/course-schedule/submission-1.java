class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int nei : adj.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int visited = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            visited++;
            for (int nei : adj.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return visited == numCourses;
    }
}
