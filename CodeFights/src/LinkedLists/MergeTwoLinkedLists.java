package LinkedLists;

/**
 * Created by Tien on 12/9/2017.
 *
 * Given two singly linked lists sorted in non-decreasing order, your task is to merge them.
 * In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.

 Example

 For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
 mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6];
 For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
 mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
 */
public class MergeTwoLinkedLists {

    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //

    //Iteration - Merge Sort
    ListNode<Integer> mergeTwoLinkedLists1(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int head = l1.value > l2.value? l2.value:l1.value;
        if(head == l1.value) l1 = l1.next;
        else l2 = l2.next;

        ListNode<Integer> res = new ListNode<>(head);
        ListNode<Integer> cur = res;

        while(l1 != null && l2 != null) {
            int curVal = l1.value > l2.value? l2.value:l1.value;
            if(curVal == l1.value) l1 = l1.next;
            else l2 = l2.next;

            cur.next = new ListNode<>(curVal);
            cur = cur.next;
        }

        while(l1 != null) {
            cur.next = new ListNode<>(l1.value);
            cur = cur.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            cur.next = new ListNode<>(l2.value);
            cur = cur.next;
            l2 = l2.next;
        }

        return res;
    }

    //Recursion
    ListNode<Integer> mergeTwoLinkedLists2(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.value < l2.value) {
            l1.next = mergeTwoLinkedLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLinkedLists2(l1, l2.next);
            return l2;
        }
    }
}
