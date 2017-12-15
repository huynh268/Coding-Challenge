package Bits;

/**
 * Created by Tien on 12/14/2017.
 *
 * You are given an array of integers in which every element appears twice, except for one.
 * Find the element that only appears one time. Your solution should have a linear runtime complexity (O(n)).
 * Try to implement it without using extra memory.

 Example

 For nums = [2, 2, 1], the output should be
 singleNumber(nums) = 1.
 */
public class SingleNumber {

    static int singleNumber1(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[0] ^= nums[i];

        return nums[0];
    }

    static int singleNumber2(int[] nums) {
        int res = 0;
        for(int num : nums)
            res ^= num;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber1(new int[] {123456789, 836133896, 65475264, 836133896, 746254373, 1000000000, 542627588,
                1000000000, 444088605, 65475264, 746254373, 542627588, 444088605}));
    }
}
