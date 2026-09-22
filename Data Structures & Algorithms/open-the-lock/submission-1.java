class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        q.offer("0000");
        visited.add("0000");
        int res = 0;
        while (!q.isEmpty()) {
            int currLength = q.size();
            for (int j = 0; j < currLength; j++) {
                String val = q.poll();
                if (val.equals(target)) return res;
                for (int i = 0; i < 4; i++) {
                    char[] chars = val.toCharArray();
                    if (chars[i] == '9') chars[i] = '0';
                    else chars[i]++;
                    String next1 = new String(chars);
                    if (!visited.contains(next1)) {
                        q.offer(next1);
                        visited.add(next1);
                    }
                    
                    chars = val.toCharArray();
                    if (chars[i] == '0') chars[i] = '9';
                    else chars[i]--;
                    String next2 = new String(chars);
                    if (!visited.contains(next2)) {
                        q.offer(next2);
                        visited.add(next2);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}

// 1000, 0100, 0010, 0001, 9000, 0900, 0090, 0009

