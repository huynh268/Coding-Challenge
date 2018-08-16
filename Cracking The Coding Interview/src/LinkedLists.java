import java.util.HashSet;
import java.util.List;

/**
 * Created by Tien on 8/15/2018.
 */
public class LinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    /**
     * Write code to remove duplicates from an unsorted linked list.
     FOLLOW UP
     How would you solve this problem if a temporary buffer is not allowed?
     * @param n
     */
    public void deleteDups1(ListNode n) {
        HashSet<Integer> hs = new HashSet<>();
        ListNode pre = null;

        while(n.next != null) {
            if(hs.contains(n.val)) {
                pre.next = n.next;
            } else {
                pre = n;
                hs.add(n.val);
            }
            n = n.next;
        }
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * Write code to remove duplicates from an unsorted linked list.
     FOLLOW UP
     How would you solve this problem if a temporary buffer is not allowed?
     * @param n
     */
    public void deleteDups2(ListNode n) {
        ListNode p1 = n;
        ListNode p2;
        while(p1 != null && p1.next != null) {
            p2 = p1;
            while(p2 != null && p2.next != null) {
                if(p1.val == p2.next.val) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
    }

    /**
     * Iteration
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Implement an algorithm to find the nth to last element of a singly linked list.
     * @param n
     * @return
     */
    public ListNode nthToLast1(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(n != 0 && p2 != null) {
            p2 = p2.next;
            n--;
        }

        if(p2 == null) return null;

        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    /**
     * Recursion
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Implement an algorithm to find the nth to last element of a singly linked list.
     * @param n
     * @return
     */
    int count = 0;
    public ListNode nthToLast2(ListNode head, int n) {
        ListNode res = head;
        if(head != null) {
            res = nthToLast2(res, n);
            if(count++ == n) {
                res = head;
            }
        }
        return res;
    }

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     * This problem cannot be solved if the node to be deleted is the last node in the linked list.
     *
     * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
     EXAMPLE
     Input: the node ‘c’ from the linked list a->b->c->d->e
     Result: nothing is returned, but the new linked list looks like a->b->d->e
     * @param head
     */
    public boolean deleteNode(ListNode head) {
        if(head == null || head.next == null)
            return false;
        head.val = head.next.val;
        head.next = head.next.next;
        return true;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     EXAMPLE
     Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
     Output: 8 -> 0 -> 8
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode l = new ListNode(0);
        ListNode cur = l;

        int i = 0;

        while(l1 != null || l2 != null || i != 0) {
            if(l1 != null) {
                i += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                i += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(i%10);
            i /= 10;
            cur = cur.next;
        }

        return l;
    }

    /**
     * Time complexity:
     * Space complexity:
     *
     * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
     DEFINITION
     Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
     EXAMPLE
     Input: A -> B -> C -> D -> E -> C [the same C as earlier]
     Output: C
     * @param head
     * @return
     */
    public ListNode FindBeginning(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        p1 = head;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
