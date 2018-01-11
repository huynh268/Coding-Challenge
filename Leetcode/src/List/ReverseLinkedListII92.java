package List;


/**
 * Created by Tien on 1/10/2018.
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.


 */
public class ReverseLinkedListII92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head == null || head.next == null || n == m)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        dummy.next = head;

        int k = n - m;
        while(m > 1) {
            start = start.next;
            m--;
        }

        ListNode cur = start.next;
        ListNode nxt = cur.next;

        while(k > 0) {
            cur.next = nxt.next;
            nxt.next = start.next;
            start.next = nxt;
            nxt = cur.next;
            k--;
        }

        return dummy.next;
    }


    ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode tmp1 = dummy;
        dummy.next = head;

        while(m > 0){
            tmp1 = tmp1.next;
            m--;
        }

        ListNode newHead = tmp1.next;
        ListNode tmp2 = newHead;
        int k = n-m;

        while(k > 0) {
            tmp2 = tmp2.next;
            k--;
        }

        ListNode tmp3 = tmp2.next;
        tmp2.next = null;

        ListNode tmp4 = reverse(newHead);
        ListNode tmp5 = tmp4;
        while(tmp5.next != null) tmp5 = tmp5.next;

        tmp1.next = tmp4;
        tmp5.next = tmp3;
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
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
}
