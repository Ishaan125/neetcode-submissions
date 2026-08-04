/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> copies = new HashMap<>();
        return dfs(node, copies);
    }

    private Node dfs(Node curr, Map<Node, Node> copies) {
        if (curr == null) {
            return null;
        }
        if (copies.containsKey(curr)) {
            return copies.get(curr);
        }
        Node copy = new Node(curr.val);
        copies.put(curr, copy);
        for (Node nei : curr.neighbors) {
            copy.neighbors.add(dfs(nei, copies));
        }
        return copy;
    }
}