package List;

import java.util.HashSet;
/**
 * Created by Tien on 1/26/2018.
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle141 {
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
     * List has no cycle: O(n) - Visited each node once
     * List has cycle   : O(n+k) - where k is the length of cycle
     *                           - Visit each node which is out of the cycle once, and node in cycle twice
     * O(1) Space - 2 pointers
     * @param head
     * @return
     */
    boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }

    /**
     * O(n) Time complexity - Visit each node once
     * O(n) Space - HashSet
     * @param head
     * @return
     */
    boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) return false;

        HashSet<ListNode> hashSet = new HashSet<>();
        while(head != null) {
            if(hashSet.contains(head)) return true;
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * O(n) Time complexity - Visit each node once
     * O(1) Space
     * @param head
     * @return
     */
    boolean hasCycle3(ListNode head) {
        if(head == null || head.next == null) return false;
        while(head != null) {
            if(head.val == Integer.MAX_VALUE) return true;
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return false;
    }
}
