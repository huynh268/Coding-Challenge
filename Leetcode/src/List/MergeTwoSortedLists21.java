package List;

/**
 * Created by Tien on 1/15/2018.
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * Iterative
     * O(n) Time complexity
     * O(1) Space
     * @param l1
     * @param l2
     * @return
     */
    ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode current = ans;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 == null) current.next = l2;
        else current.next = l1;

        return ans.next;
    }

    /**
     * Recursive
     * O(n) Time complexity
     * O(n) Space
     * @param l1
     * @param l2
     * @return
     */
    ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
