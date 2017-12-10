package LinkedLists;

/**
 * Created by Tien on 11/7/2017.
 */

public class RemoveKFromList {

    public ListNode<Integer> add(ListNode<Integer> l, int value) {
        ListNode<Integer> newNode = new ListNode<>(value);
        newNode.next = l;
        l = newNode;
        return  l;
    }

    public ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if(l == null) return l;
        ListNode<Integer> temp = new ListNode<>(null);
        temp.next = l;
        ListNode<Integer> current = temp;

        while(current.next != null) {
            if(current.next.value != k) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }

        return temp.next;
    }

    public void print(ListNode<Integer> l) {
        ListNode<Integer> cur = l;
        while(cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(2);
        RemoveKFromList l = new RemoveKFromList();
        l.print(l.add(list, 3));
        l.add(list, 1);
        l.add(list, 2);
        l.add(list, 3);
        l.add(list, 4);
        l.print(l.add(list, 5));

        l.print(l.removeKFromList(list, 1));
        l.print(list);

    }
}
