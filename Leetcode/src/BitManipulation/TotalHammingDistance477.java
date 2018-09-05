package BitManipulation;

/**
 * Created by Tien on 6/6/2018.
 *
 * https://leetcode.com/problems/total-hamming-distance/description/
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 Now your job is to find the total Hamming distance between all pairs of the given numbers.

 Example:
 Input: 4, 14, 2
 Output: 6

 Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 showing the four bits relevant in this case). So the answer will be:
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

 Note:
 Elements of the given array are in the range of 0 to 10^9
 Length of the array will not exceed 10^4.

 */
public class TotalHammingDistance477 {


    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance1(int[] nums) {
        int ans = 0;
        int[] count0and1 = new int[2];
        int count = 0;

        while(count < nums.length) {
            count = 0;
            count0and1[0] = 0;
            count0and1[1] = 0;

            for(int i = 0; i < nums.length; i++) {
                count0and1[nums[i]%2]++;
                nums[i] >>= 1;
                if(nums[i] == 0) count++;
            }

            ans += count0and1[0]*count0and1[1];
        }

        return ans;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance2(int[] nums) {
        int ans = 0;

        for(int i = 0; i < 32; i++) {
            int countOne = 0;
            for(int j = 0; j < nums.length; j++) {
                countOne += nums[j]%2 == 0 ? 0 : 1;
                nums[j] >>= 1;
            }
            ans += countOne * (nums.length - countOne);
        }

        return ans;
    }
}
