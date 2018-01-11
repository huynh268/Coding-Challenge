package List;

/**
 * Created by Tien on 1/10/2018.
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * Reverse a singly linked list.
 */
public class ReverseLinkedList206 {
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
     * @param head
     * @return
     */
    ListNode reverseList1(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    /**
     * Recursive
     * O(n) Time complexity
     * O(n) Space - Store n nodes in n stacks
     * @param head
     * @return
     */
    ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode previous = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return previous;
    }
}
