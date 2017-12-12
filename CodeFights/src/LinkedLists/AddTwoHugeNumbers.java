package LinkedLists;

/**
 * Created by Tien on 12/9/2017.
 *
 * You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.

 Example

 For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
 addTwoHugeNumbers(a, b) = [9876, 5434, 0].

 Explanation: 987654321999 + 18001 = 987654340000.

 For a = [123, 4, 5] and b = [100, 100, 100], the output should be
 addTwoHugeNumbers(a, b) = [223, 104, 105].

 Explanation: 12300040005 + 10001000100 = 22301040105.
 */
public class AddTwoHugeNumbers {

    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> temp1 = reverse(a);
        ListNode<Integer> temp2 = reverse(b);

        int rem = 0;
        int i = temp1.value+temp2.value;
        if(i > 9999) {
            rem = 1;
            i = i-10000;
        }

        temp1 = temp1.next;
        temp2 = temp2.next;
        ListNode<Integer> res = new ListNode<>(i);
        ListNode<Integer> cur = res;

        while(temp1 != null || temp2 != null ||rem != 0) {
            int n = temp1 == null? 0:temp1.value;
            int m = temp2 == null? 0:temp2.value;

            i = m + n + rem;

            rem = 0;
            if(i > 9999) {
                rem = 1;
                i = i-10000;
            }
            ListNode<Integer> temp = new ListNode<>(i);
            cur.next = temp;
            cur = cur.next;

            temp1 = temp1 == null? null:temp1.next;
            temp2 = temp2 == null? null:temp2.next;

        }

        return reverse(res);
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
}
