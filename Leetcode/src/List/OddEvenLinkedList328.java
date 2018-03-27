package List;

/**
 * Created by Tien on 3/26/2018.
 *
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList328 {
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
     * @return
     */
    public ListNode oddEvenList1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode curOdd = odd;
        ListNode curEven = even;
        int n = 0;
        while(head != null) {
            if(n % 2 == 0) {
                curOdd.next = head;
                curOdd = curOdd.next;
            } else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
            n++;
        }

        curEven.next = null;
        curOdd.next = even.next;
        return odd.next;
    }

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param head
     * @return
     */
    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = odd.next, evenHead = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
