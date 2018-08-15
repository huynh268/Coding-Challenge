import java.util.HashSet;

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
     * Write code to remove duplicates from an unsorted linked list.
     FOLLOW UP
     How would you solve this problem if a temporary buffer is not allowed?
     * @param n
     */
    public void deleteDups2(ListNode n) {

    }

    /**
     * Implement an algorithm to find the nth to last element of a singly linked list.
     * @param n
     * @return
     */
    public ListNode nthToLast(ListNode head, int n) {
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
}
