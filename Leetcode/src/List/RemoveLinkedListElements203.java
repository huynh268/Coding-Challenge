package List;

/**
 * Created by Tien on 3/8/2018.
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements203 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * Recursive
     * O(n) Time complexity
     * O(n) Space
     * @param head
     * @param val
     * @return
     */
    ListNode removeElements1(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements1(head.next, val);
        if(head.val == val) return head.next;
        return head;
    }

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param head
     * @param val
     * @return
     */
    ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previousNode = dummy;
        ListNode currentNode = head;

        while(currentNode != null) {
            if(currentNode.val == val) {
                previousNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return dummy.next;
    }

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param head
     * @param val
     * @return
     */
    ListNode removeElements3(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next;
        ListNode currentNode=  head;
        while(currentNode != null && currentNode.next != null) {
            if(currentNode.next.val == val) currentNode.next = currentNode.next.next;
            else currentNode = currentNode.next;
        }
        return head;
    }
}
