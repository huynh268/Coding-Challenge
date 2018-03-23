package List;

/**
 * Created by Tien on 3/22/2018.
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList86 {
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
     * O(n) Space
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessNodes = new ListNode(-1);
        ListNode greaterNodes = new ListNode(-1);
        ListNode currentLess = lessNodes;
        ListNode currentGreater = greaterNodes;

        while(head != null) {
            if(head.val >= x) {
                currentGreater.next = head;
                currentGreater = currentLess.next;
            } else {
                currentLess.next = head;
                currentLess = currentLess.next;
            }
            head = head.next;
        }

        currentGreater.next = null; //Avoiding MLE, TLE
        currentLess.next = greaterNodes.next;

        return lessNodes.next;
    }
}
