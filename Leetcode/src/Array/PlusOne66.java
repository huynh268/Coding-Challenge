package Array;

/**
 * Created by Tien on 1/6/2018.
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne66 {

    int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        //In case 99 or 9999...
        //After the loop done, we have {0,0,0,..,0}
        int[] ans = new int[digits.length+1];
        ans[0] = 1;
        return ans;
    }
}
