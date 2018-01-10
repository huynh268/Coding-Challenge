package List;

/**
 * Created by Tien on 1/9/2018.
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers2 {
    ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int value = l1.val + l2.val;
        int carry = value/10;

        ListNode ans = new ListNode(value%10);
        ListNode cur1 = l1.next, cur2 = l2.next;

        ListNode cur = ans;

        while(cur1 != null && cur2 != null) {
            value = cur1.val + cur2.val + carry;
            cur.next = new ListNode(value%10);
            carry = value/10;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while(cur1 != null) {
            value = cur1.val + carry;
            cur.next = new ListNode(value%10);
            carry = value/10;
            cur = cur.next;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            value = cur2.val + carry;
            cur.next = new ListNode(value%10);
            carry = value/10;
            cur = cur.next;
            cur2 = cur2.next;
        }

        if(carry != 0)
            cur.next = new ListNode(1);

        return ans;
    }

    ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(l1 != null || l2 != null || carry != 0) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            cur.next = new ListNode(carry%10);
            carry /= 10;
            cur = cur.next;
        }
        return head.next;
    }
}
