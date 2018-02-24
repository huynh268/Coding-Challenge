package List;

/**
 * Created by Tien on 2/23/2018.
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 Example:

 Given 1->2->3->4->5->NULL and k = 2,

 return 4->5->1->2->3->NULL.
 */
public class RotateList61 {
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
     * @param k
     * @return
     */
    ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = 1;
        ListNode currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
            n++;
        }

        currentNode.next = head;
        currentNode = currentNode.next;
        int i = n - k%n;
        while(i > 1) {
            currentNode = currentNode.next;
            i--;
        }
        ListNode newHead = currentNode.next;
        currentNode.next = null;
        return newHead;
    }
}
