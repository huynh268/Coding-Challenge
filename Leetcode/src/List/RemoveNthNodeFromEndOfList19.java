package List;

/**
 * Created by Tien on 3/13/2018.
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * Two pass - First pass to count the length of the list
     *          - Second pass to remove the nth node from the end of the list
     * O(N) Time complexity
     * O(1) Space
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode currentNode = head;
        int count = 0;

        while(currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }

        currentNode = dummy;
        count -= n;
        while(count > 0) {
            currentNode = currentNode.next;
            count--;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    /**
     * One pass - Maintain the distance between first and second nodes equal to n
     *          - When first reaches the end of the list, second reaches the (n+1)th node from the end of the list
     * O(N) Time complexity
     * O(1) Space
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = head;
        ListNode second = new ListNode(-1);
        ListNode dummy = second;
        second.next = head;

        while(n > 0) {
            first = first.next;
            n--;
        }

        while(first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
