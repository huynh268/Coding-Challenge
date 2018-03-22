package List;

/**
 * Created by Tien on 3/20/2018.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII82 {
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
     * Two Pointers
     * O(N) Time complexity
     * O(1) Space
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fastPointer = head;
        ListNode slowPointer = dummy;

        while(fastPointer != null) {
            while(fastPointer.next != null && fastPointer.val == fastPointer.next.val) {
                fastPointer = fastPointer.next;
            }

            if(slowPointer.next != fastPointer) {
                slowPointer.next = fastPointer.next;
                fastPointer = slowPointer.next;
            } else {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }

        return dummy.next;
    }

    /**
     * Recursive
     * O(N) Time complexity
     * O(N) Space
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        if(head.next != null && head.val == head.next.val) {
            while(head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }
}
