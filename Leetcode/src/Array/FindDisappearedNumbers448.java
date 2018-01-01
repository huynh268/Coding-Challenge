package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

/**
 * Created by Tien on 1/1/2018.
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 */
public class FindDisappearedNumbers448 {

    /**
     * O(n) Time complexity - O(1) Space
     * @param nums
     * @return
     */
    List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int n : nums) {
            int index = Math.abs(n) - 1;
            if(nums[index] > 0)
                nums[index]  = -nums[index];
        }

        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0)
                result.add(i);

        return result;
    }

    /**
     * O(n) Time complexity - O(n) Space
     * @param nums
     * @return
     */
    List<Integer> findDisappearedNumbers2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int n : nums)
            hashSet.add(n);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            if(!hashSet.contains(i+1))
                result.add(i+1);

        return result;
    }
}
