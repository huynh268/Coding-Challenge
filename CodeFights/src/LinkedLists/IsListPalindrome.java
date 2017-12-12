package LinkedLists;

import java.util.Stack;

/**
 * Created by Tien on 12/8/2017.
 * Given a singly linked list of integers, determine whether or not it's a palindrome.

 Example

 For l = [0, 1, 0], the output should be
 isListPalindrome(l) = true;
 For l = [1, 2, 2, 3], the output should be
 isListPalindrome(l) = false.
 */
public class IsListPalindrome {

    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //

    //Reverse the second half of the linked list then compare first and second
    boolean isListPalindrome1(ListNode<Integer> l) {
        ListNode<Integer> slowPointer = l;
        ListNode<Integer> fastPointer = l;

        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next; //Run 2x faster than slowPointer
            slowPointer = slowPointer.next;
        }

        if(fastPointer != null) //l.size() is odd
            slowPointer = slowPointer.next;

        ListNode<Integer> temp1 = reverse(slowPointer);
        ListNode<Integer> temp2 = l;

        while(temp1 != null) {
            if(!temp1.value.equals(temp2.value)) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    ListNode<Integer> reverse(ListNode<Integer> l) {
        ListNode<Integer> current = l;
        ListNode<Integer> previous = null;
        ListNode<Integer> next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    //Using stack
    boolean isListPalindrome2(ListNode<Integer> l) {
        Stack<Integer> stack  = new Stack<>();
        ListNode<Integer> temp1 = l;
        int length = 0;

        while (temp1 != null) {
            stack.push(temp1.value);
            temp1 = temp1.next;
            length++;
        }

        ListNode<Integer> temp2 = l;

        int i = 0;
        while(i < length/2) {
            if (stack.pop() != temp2.value) return false;
            temp2 = temp2.next;
            i++;
        }

        return true;
    }
}
