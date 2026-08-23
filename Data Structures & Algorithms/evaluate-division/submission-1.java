class Solution {
    private double[] res;
    private Map<String, List<Pair>> adj;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String source = equations.get(i).get(0);
            String target = equations.get(i).get(1);
            
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(target, values[i]));
            adj.putIfAbsent(target, new ArrayList<>());
            adj.get(target).add(new Pair(source, 1.0/values[i]));
        }

        res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!adj.containsKey(queries.get(i).get(0)) || !adj.containsKey(queries.get(i).get(1))) {
                res[i] = -1.0;
            }
            else {
                res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), queries.get(i).get(0), 1.0, new HashSet<>());
            }
        }
        return res;
    }

    private double dfs(String a, String b, String curr, double total, Set<String> visited) {
        if (curr.equals(b)) {
            return total;
        }
        for (Pair pair : adj.get(curr)) {
            if (!visited.contains(pair.node)) {
                visited.add(pair.node);
                double check = dfs(a, b, pair.node, total * pair.weight, visited);
                if (check != -1.0) {
                    return check;
                } 
                visited.remove(pair.node);
            }
        }
        return -1.0;
    }
}

class Pair {
    String node;
    double weight;
    public Pair(String node, double weight) {
        this.node = node;
        this.weight = weight;
    }
}

// a/b=x,b/c=y   a-(x)>b-(y)>c
// a/c = yx

// build adj connect a to b with weight x if a/b=x
// start at a and go to c, mutliply each weight together