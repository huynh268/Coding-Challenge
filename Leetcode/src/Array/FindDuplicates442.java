package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

/**
 * Created by Tien on 1/1/2018.
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 */
public class FindDuplicates442 {

    /**
     * O(n) Time complexity - O(n) Space
     * @param nums
     * @return
     */
    List<Integer> findDuplicates1(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int n : nums) {
            if(hashSet.contains(n))
                result.add(n);
            else
                hashSet.add(n);
        }
        return result;
    }

    /**
     * O(n) Time Complexity - O(1) Space
     * @param nums
     * @return
     */
    List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int n : nums) {
            int index  = Math.abs(n)-1;
            if(nums[index] < 0) result.add(index+1);
            else
                nums[index] = -nums[index];
        }

        return result;
    }
}
