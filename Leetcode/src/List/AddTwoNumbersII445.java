package List;

import java.util.Stack;

/**
 * Created by Tien on 2/28/2018.
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII445 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * Reversing Linked List
     * O(n) Time complexity
     * O(n) Space
     * @param l1
     * @param l2
     * @return
     */
    ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            currentNode.next = new ListNode(carry%10);
            currentNode = currentNode.next;
            carry /= 10;
        }

        return reverse(dummy.next);
    }

    ListNode reverse(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;

        while(currentNode != null) {
            ListNode temp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;
        }

        return previousNode;
    }

    /**
     * Stack
     * O(n) Time complexity
     * O(n) Space
     * @param l1
     * @param l2
     * @return
     */
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push((l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        Stack<ListNode> stack = new Stack<>();
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            if(!stack1.isEmpty()) {
                carry += stack1.peek().val;
                stack1.pop();
            }
            if(!stack2.isEmpty()) {
                carry += stack2.peek().val;
                stack2.pop();
            }

            ListNode tmp = new ListNode(carry%10);
            if(!stack.isEmpty()) tmp.next = stack.peek();
            stack.push(tmp);
            carry /= 10;
        }

        return stack.peek();
    }
}
