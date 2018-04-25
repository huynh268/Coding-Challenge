package Hashtable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Tien on 4/24/2018.
 *
 * https://leetcode.com/problems/distribute-candies/description/
 *
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.

 Example 1:
 Input: candies = [1,1,2,2,3,3]
 Output: 3
 Explanation:
 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 The sister has three different kinds of candies.

 Example 2:
 Input: candies = [1,1,2,3]
 Output: 2
 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 The sister has two different kinds of candies, the brother has only one kind of candies.

 Note:
 The length of the given array is in range [2, 10,000], and will be even.
 The number in given array is in range [-100,000, 100,000].
 */
public class DistributeCandies575 {

    /**
     * O(nlogn) Time complexity - Sort
     * O(1) Space 
     * @param candies
     * @return
     */
    public int distributeCandies1(int[] candies) {
        Arrays.sort(candies);
        int kinds = 1;
        for(int i = 1; i < candies.length; i++) {
            if(candies[i] != candies[i-1]) kinds++;
        }
        return Math.min(kinds, candies.length/2);
    }

    /**
     * O(n) Time comeplxity
     * O(n) Space
     * @param candies
     * @return
     */
    public int distributeCandies2(int[] candies) {
        HashSet<Integer> h = new HashSet<>();
        for(int i : candies) h.add(i);
        return Math.min(h.size(), candies.length/2);
    }
}
