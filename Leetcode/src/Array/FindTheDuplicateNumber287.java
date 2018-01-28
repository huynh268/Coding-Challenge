package Array;

import java.util.Arrays;
import java.util.HashSet;
/**
 * Created by Tien on 1/27/2018.
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.

 Note:
 - You must not modify the array (assume the array is read only).
 - You must use only constant, O(1) extra space.
 - Your runtime complexity should be less than O(n2).
 - There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber287 {

    /**
     * Sorting
     * O(nlogn) Time complexity - Sorting alg time complexity
     * O(n) Space - input modified
     * O(1) Space - input not modified
     * @param nums
     * @return
     */
    int findDuplicate1(int[] nums) {
        int[] copy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);

        for(int i = 1; i < nums.length; i++) {
            if(copy[i] == copy[i-1]) return copy[i];
        }
        return -1;
    }

    /**
     * HashSet
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    int findDuplicate2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int num : nums) {
            if(hashSet.contains(num)) return num;
            hashSet.add(num);
        }

        return -1;
    }


    /**
     * Floy's Cycle Detection
     *
     * Let's consider indexes and values be as nodes and next nodes.
     * Since values are in range [1,n], and there is a duplicate value, the list must have a cycle
     *
     * For example:
     * index [0, 1, 2, 3, 4, 5, 6, 7]
     * nums  [1, 3, 5, 4, 2, 7, 2, 6]
     *
     * We have the linked list:
     * 1 -> 3 -> 4 -> 2 -> 5
     *                ^    |
     *                |    v
     *                6 <- 7
     *
     * 2 is the entry of cycle
     *
     * The problem now becomes find the entry of cycle in the linked list.
     *
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int findDuplicate3(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        //Find intersection
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        //Find the entry of cycle
        fast = nums[0];
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
