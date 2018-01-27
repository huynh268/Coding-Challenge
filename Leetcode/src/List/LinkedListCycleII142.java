package List;

import java.util.HashSet;
/**
 * Created by Tien on 1/26/2018.
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycleII142 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    /**
     * Floy's Cycle Detection
     * O(n) Time complexity
     * O(1) Space
     * @param head
     * @return
     */
    ListNode detectCycle1(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        //Find intersection of fast and slow pointers
        while(fast != null || fast.next == null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break; //If they meet,the list has cycle
        }

        //The list has no cycle
        if(fast == null || fast.next == null)
            return null;

        fast = head;
        //Find the node where cycle begins
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null)
            return null;

        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode current = head;

        while(current != null) {
            if(hashSet.contains(current))
                return current;
            hashSet.add(current);
            current = current.next;
        }
        return null;
    }
}
