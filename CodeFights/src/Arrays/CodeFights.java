package Arrays;

import javax.swing.plaf.PanelUI;
import java.util.HashSet;

/**
 * Created by Tien on 10/16/2017.
 */
public class CodeFights {

    /*
     * Several friends live along a straight street. They are friends, thus they enjoy visiting each other.
     * However, they are lazy so none of them wants to visit a friend living more than maxDist meters away from them.
     * Given array houses representing coordinates of points where the friends live (in meters) and an integer maxDist,
     * return an array representing the number of friends each person would be willing to visit.
     *
     * Example
     *      For houses = [1, 2, 4, 8, 10] and maxDist = 5, the output should be
     *      lazyFriends(houses, maxDist) = [2, 2, 3, 2, 1].
     */

    //The time complexity for this algorithm is O(n^2) and O(n) space
    public static int[] lazyFriends(int[] houses, int maxDist) {
        int l = houses.length, m, n;
        int res[] = new int[l];
        for(int i: res)
            res[i] = 0;

        for(m = 0; m < l-1; m++)
            for(n = m+1; n < l; n++)
                if(houses[n]-houses[m]<= maxDist) {
                    res[m]++;
                    res[n]++;
                }
        return res;
    }

    /*
     * Given an array a that contains only numbers in the range from 1 to a.length,
     * find the first duplicate number for which the second occurrence has the minimal index.
     * In other words, if there are more than 1 duplicated numbers, return the number for
     * which the second occurrence has a smaller index than the second occurrence of the other number does.
     * If there are no such elements, return -1.
     *
     * Example
     *      For a = [2, 3, 3, 1, 5, 2], the output should be
     *      firstDuplicate(a) = 3.
     *      There are 2 duplicates: numbers 2 and 3.
     *      The second occurrence of 3 has a smaller index than than second occurrence of 2 does, so the answer is 3.
     *
     *      For a = [2, 4, 3, 5, 1], the output should be
     *      firstDuplicate(a) = -1.
     */

    //Time complexity is O(n), and Space complexity is O(n)
    public static int firstDuplicate1(int[] a) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < a.length; i++) {
            if(hashSet.contains(a[i])) {
                return a[i];
            } else {
                hashSet.add(a[i]);
            }
        }
        return -1;
    }

    //Time complexity is O(n), and Space complexity is O(1)
    public static int firstDuplicate2(int[] a) {
        for(int i: a) {
            int temp = i > 0? i:-i;
            if(a[temp - 1] > 0) {
                a[temp - 1] = -a[temp-1];
            } else {
                return temp;
            }
        }
        return -1;
    }

    /**
     * Determine if a number can be expressed as a sum of some consecutive positive integers.

     Example

     For n = 9, the output should be
     isSumOfConsecutive(n) = true.

     Explanation: It is possible to get n = 9 in the following way: 2 + 3 + 4 = 9.

     For n = 8, the output should be
     isSumOfConsecutive(n) = false.
     * @param n
     * @return
     */
    //O(1) Time complexity
    public static boolean isSumOfConsecutive(int n) {
        //If a number is a power of two, then it cannot be expressed as a sum of consecutive numbers otherwise Yes.
        //Proof: http://www.cut-the-knot.org/arithmetic/UnpropertyOfPowersOf2.shtml
        return (((n&(n-1))!=0) && n!=0);
    }

    public static void main(String[] args) {

        /*
            lazyFriends problem
         */
        int[] houses1 = {1, 2, 4, 8, 10},
                houses2 = {-5, 0, 5, 10, 15},
                houses3 = {1, 2, 3, 4, 5, 6};

        System.out.print("houses1 and maxDist = 5 : ");
        for (int i : lazyFriends(houses1, 5)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("houses2 and maxDist = 10: ");
        for (int i : lazyFriends(houses2, 10)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("houses3 and maxDist = 3 : ");
        for (int i : lazyFriends(houses3, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();

        /*
            firstDuplicate problem
         */
        int[] a = {2, 3, 3, 1, 5, 2};
        System.out.println("firstDuplicate1 of a = [2, 3, 3, 1, 5, 2]: " + firstDuplicate1(a));
        System.out.println("firstDuplicate2 of a = [2, 3, 3, 1, 5, 2]: " + firstDuplicate2(a));
    }
}
