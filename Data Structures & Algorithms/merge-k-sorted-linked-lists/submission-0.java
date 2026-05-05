/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (true) {
            int min = 1001;
            int minIdx = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    minIdx = i;
                }
            }
            if (min == 1001) {
                return head.next;
            }
            curr.next = lists[minIdx];
            curr = curr.next;
            lists[minIdx] = lists[minIdx].next;
        }
    }
}
