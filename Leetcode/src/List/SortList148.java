package List;

/**
 * Created by Tien on 1/15/2018.
 *
 *https://leetcode.com/problems/sort-list/description/
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList148 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * O(nlogn) Time complexity
     * O(n) Space
     * @param head
     * @return
     */
    ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode preSlow = slow;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }

        preSlow.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeLists(l1, l2);
    }

    /**
     * O(n+m) Time complexity
     * O(n+m) Space
     * @param l1
     * @param l2
     * @return
     */
    ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }
}
