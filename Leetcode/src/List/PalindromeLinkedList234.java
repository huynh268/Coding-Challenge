package List;

/**
 * Created by Tien on 1/11/2018.
 *
 *https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList234 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //head.size() is odd
        if(fast != null) {
            slow = slow.next;
        }

        fast = head;
        slow = reverse(slow);

        while(slow != null) {
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }

        return previous;
    }
}
