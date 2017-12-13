package LinkedLists;

/**
 * Created by Tien on 12/9/2017.
 *
 * Given a singly linked list of integers l and a non-negative integer n, move the last n list nodes to the beginning of the linked list.

 Example

 For l = [1, 2, 3, 4, 5] and n = 3, the output should be
 rearrangeLastN(l, n) = [3, 4, 5, 1, 2];
 For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be
 rearrangeLastN(l, n) = [7, 1, 2, 3, 4, 5, 6].
 */
public class RearrangeLastN {

    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //

    //1 - Get l.size()
    //2 - Get Node at position l.size()-n + 1
    //3 - Move each single node to the start of the list until no node left
    //EX: 1->2->3->4->5 , n = 3
    //      -1(temp node to remember the head)-> 3->1->2->4->5
    //      -1->3->4->1->2->5
    //      -1->3->4->5->1->2
    //
    //This solution is not efficient, but good for practicing how to move nodes around
    ListNode<Integer> rearrangeLastN1(ListNode<Integer> l, int n) {
        if(n == 0) return l;
        ListNode<Integer> len = l;
        int count = 0;
        while(len!=null) {
            len=len.next;
            count++;
        }
        if(count == n) return l;

        ListNode<Integer> temp = new ListNode<Integer>(-1);
        ListNode<Integer> res = temp;
        ListNode<Integer> head = l;
        ListNode<Integer> current = l;
        int m = count-n;
        while(m != 1) {
            current = current.next;
            m--;
        }

        if(current.next == null ) return l;

        ListNode<Integer> tail = current;
        current = current.next;

        while(current != null) {
            temp.next = current;
            temp = current;
            tail.next = current.next;
            current.next = head;
            current = tail.next;

        }
        return res.next;
    }


    //Using 2 pointers - fast and slow to find the last n nodes with O(n) running time
    ListNode<Integer> rearrangeLastN2(ListNode<Integer> l, int n) {
        if(n == 0) return l;

        ListNode<Integer> fast = l;
        ListNode<Integer> slow = l;

        //After the loop stops, fast.size() = l.size() - n;
        while(n != 0) {
            n--;
            fast = fast.next;
        }

        //n = list.size
        if(fast == null) return l;

        //fast.size() = l.size()- n and slow.size() = l.size() before going through the loop.
        //The loop runs l.size()-n times. Therefore, after the loop stops slow.size() = l.size() - (l.size() - n) = n
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode<Integer> result = slow.next; //Create a new linked list that has n nodes of l from the end
        slow.next = null; //slow is the node at  l.size - n + 1 position
        fast.next = l; //fast is the last node of new linked list, then link it to the first node of l

        return result;
    }
}
