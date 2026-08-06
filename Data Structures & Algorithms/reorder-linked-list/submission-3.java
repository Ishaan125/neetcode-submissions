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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode list1 = head;
        ListNode list2 = prev;
        while (list2 != null) {
            ListNode temp1 = list1.next; // 12
            ListNode temp2 = list2.next; // 43
            list1.next = list2; // 0512
            list2.next = temp1; // ->
            list1 = temp1; // 12
            list2 = temp2; // 43
        }
    }
}

//0123456 mid = 4 = 7/2  //0123  654
//012345 mid = 3 = 6/2  //012 543
