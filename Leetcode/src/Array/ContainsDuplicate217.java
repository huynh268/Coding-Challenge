package Array;
import java.util.HashSet;

/**
 * Created by Tien on 1/6/2018.
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.


 */
public class ContainsDuplicate217 {

    boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums) {
            if(hs.contains(n))
                return true;
            else
                hs.add(n);
        }
        return false;
    }
}
