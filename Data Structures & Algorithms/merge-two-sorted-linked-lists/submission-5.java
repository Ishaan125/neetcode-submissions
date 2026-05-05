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
    /*
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(0);
        ListNode mergeCurr = merge;

        while (list1 != null && list2 != null) {
            if (list2.val < list1.val) {
                mergeCurr.next = list2;
                list2 = list2.next;
            }
            else {
                mergeCurr.next = list1;
                list1 = list1.next;
            }
            mergeCurr = mergeCurr.next;
        }

        if (list2 != null) {
            mergeCurr.next = list2;
        }
        else if (list1 != null) {
            mergeCurr.next = list1;
        }

        return merge.next;
    }
    */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}