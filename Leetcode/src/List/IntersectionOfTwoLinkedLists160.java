package List;

import java.util.HashSet;

/**
 * Created by Tien on 2/12/2018.
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                    ↘
                     c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:
 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists160 {

    /**
     * 2 pointers
     * O(A+B) Time complexity
     * O(1) Space
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0;
        int lenB = 0;

        // Find length headA
        while(nodeA.next != null) {
            lenA++;
            nodeA = nodeA.next;
        }

        // Find length headB
        while(nodeB.next != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        // headA and headB have no intersection
        if(nodeA != nodeB) return null;

        ListNode longerList = lenA > lenB ? headA : headB;
        ListNode shorterList = longerList == headA ? headB : headA;
        int diff = Math.abs(lenA-lenB);

        while(diff != 0) {
            diff--;
            longerList = longerList.next;
        }

        while(longerList != shorterList) {
            longerList = longerList.next;
            shorterList = shorterList.next;
        }

        return longerList;
    }

    /**
     * HashTable
     * O(A+B) Time complexity
     * O(A+B) Space
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(hashSet.contains(headB)) return headB;
            else {
                hashSet.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}
