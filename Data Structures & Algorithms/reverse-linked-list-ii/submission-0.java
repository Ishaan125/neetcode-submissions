class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Dummy node simplifies edge cases where left == 1
        ListNode dummy = new ListNode(0, head);

        // Step 1: move `prev` to the node before `left`
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Now prev.next is the first node that will be reversed
        ListNode curr = prev.next;

        // Step 2: reverse the segment from left to right
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;        // pick node after curr
            curr.next = next.next;   // detach next from list
            next.next = prev.next;   // move next to the front
            prev.next = next;        // reconnect
        }

        return dummy.next;
    }
}
