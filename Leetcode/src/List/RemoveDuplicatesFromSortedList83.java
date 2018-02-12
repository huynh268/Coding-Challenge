package List;

/**
 * Created by Tien on 2/12/2018.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList83 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param head
     * @return
     */
    ListNode deleteDuplicates1(ListNode head) {
        ListNode currentNode = head;
        while(currentNode != null && currentNode.next != null) {
            if(currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param head
     * @return
     */
    ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates2(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
