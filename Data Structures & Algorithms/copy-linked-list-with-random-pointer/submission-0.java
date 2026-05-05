/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node paste = new Node(curr.val);
            copy.put(curr, paste);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node paste = copy.get(curr);
            paste.next = copy.get(curr.next);
            paste.random = copy.get(curr.random);
            curr = curr.next;
        }

        return copy.get(head);
    }
}
