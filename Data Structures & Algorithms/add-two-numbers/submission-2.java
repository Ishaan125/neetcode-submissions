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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        ListNode curr2 = l2;
        if (curr2 == null) {
            return l1;
        }
        curr.val += curr2.val;
        if (curr.val >= 10) {
            if (curr.next != null) {
                curr.next.val++;
            }
            else {
                curr.next = new ListNode(1);
            }
            curr.val -= 10;
        }
    
        while (curr.next != null || curr2.next != null) {
            if (curr.next == null) {
                curr.next = new ListNode(0);
            }
            else if (curr2.next == null) {
                curr2.next = new ListNode(0);
            }

            curr.next.val += curr2.next.val;
            if (curr.next.val >= 10) {
                if (curr.next.next != null) {
                    curr.next.next.val++;
                }
                else {
                    curr.next.next = new ListNode(1);
                }
                curr.next.val -= 10;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }

        return l1;
    }
}
